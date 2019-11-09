package com.riji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 杨鹏发
 * @date 2019/11/9 0009
 */
@Configuration
@EnableSwagger2
//swagger要放在网关里  因为微服务每个服务都需要有swagger
public class SwaggerConfig {

    @Bean
    public Docket greatSwagger(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().
                //表示生成api的扫包范围
                apis(RequestHandlerSelectors.basePackage("com.riji")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("发哥系统").description("订单模块").
                termsOfServiceUrl("http://www.xxx.com").version("1.0").build();
    }
}
