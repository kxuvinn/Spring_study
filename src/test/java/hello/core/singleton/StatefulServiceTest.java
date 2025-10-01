package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService s1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService s2 = ac.getBean("statefulService", StatefulService.class);

        // A사용자 주문
        s1.order("userA", 10000);
        // B사용자 주문 → A의 값이 덮어써짐
        s2.order("userB", 20000);

        int price = s1.getPrice();
        System.out.println("최종 price = " + price);

        assertThat(price).isEqualTo(20000); // A의 주문 금액이 사라짐
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
