package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        // basePackages = "hello.core.member",
        // basePackages = {"hello.core.member", "hello.core.order"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,  classes = Configuration.class)
)
public class AutoAppConfig {

}
