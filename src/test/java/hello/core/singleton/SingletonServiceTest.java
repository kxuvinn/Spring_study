package hello.core.singleton;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SingletonServiceTest {

    @Test
    void singletonServiceTest() {
        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        assertThat(s1).isSameAs(s2);
    }
}
