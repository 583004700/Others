package com.ry.xk;

import org.springframework.beans.factory.annotation.Value;
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
 * swagger自定义配置
 * 
 * @ClassName: Swagger2
 * @author Administrator
 * @date 2018年4月18日
 */
@Configuration
@EnableSwagger2
public class Swagger2
{
    @Value("${swagger.show}")
    private boolean swaggerShow;
    
    @Bean
    public Docket createRestApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ry.xk"))
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("此API提供接口调用")
                .contact("xingrenqiang")
                .version("1.0")
                .build();
    }
}