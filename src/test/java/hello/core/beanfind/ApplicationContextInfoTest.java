package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDifinitionName : beanDifinitionNames) {
            Object bean = ac.getBean(beanDifinitionName);
            System.out.println("name = " + beanDifinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("Application 빈 출력하기")
    void  ffindApplicationBean() {
        String[] beanDifinitionNames = ac.getBeanDefinitionNames();
        for (String beanDifinitionName : beanDifinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDifinitionName);

            // ROLE_APPLICATION : 사용자가 직접 등록한 Bean 을 식별하기 위한 Role
            // ROLE_INFRASTRUCTURE : Spring이 직접 등록한 Bean 을 식별하기 위한 Role
            // NoSuchBeanDefinitionException : 조회 대상 Spring Bean이 없으면 터지는 Exception.
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDifinitionName);
                System.out.println("name = " + beanDifinitionName + "object = " + bean);
            }
        }
    }
}
