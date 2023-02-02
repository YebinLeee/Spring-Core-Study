package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatelessServiceTest {

    @Test
    void statelessServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statefulService1 = ac.getBean(StatelessService.class);
        StatelessService statefulService2 = ac.getBean(StatelessService.class);

        // Thread A: A 사용자 A 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        // Thread B: B 사용자 B 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        // Thread A : 사용자 A 주문 금액 조회
        System.out.println("userAprice = " + userAprice);

        // Assertions.assertThat(statefulService1).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatelessService statelessService(){
            return new StatelessService();
        }
    }

}