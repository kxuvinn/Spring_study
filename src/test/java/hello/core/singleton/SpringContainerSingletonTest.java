package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SpringContainerSingletonTest {

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService m1 = ac.getBean("memberService", MemberService.class);
        MemberService m2 = ac.getBean("memberService", MemberService.class);

        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        assertThat(m1).isSameAs(m2);
    }
}
