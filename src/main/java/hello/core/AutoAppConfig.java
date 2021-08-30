package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //예제 코드들을 최대한 살리기 위한 excludeFilters, 실무에서는 거의 사용하지 않는다.
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,  따로 설정하지 않고 root 디렉터리에 두는것을 스프링 부트에서 권장한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig  {

}
