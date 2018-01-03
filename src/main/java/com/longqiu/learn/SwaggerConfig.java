package com.longqiu.learn;

import com.longqiu.learn.config.ConfigCenter;
import org.aeonbits.owner.ConfigFactory;
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
 * Created by QIUJ003 on 2017/12/15.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        ConfigCenter cfg = ConfigFactory.create(ConfigCenter.class);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("使用Swagger2构建RESTful APIs")
                .description("客户端与服务端接口文档")
                //.termsOfServiceUrl("http://localost:" + cfg.getPort())
                .contact("test swagger")
                .version("1.0.0")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.longqiu.learn"))
                .paths(PathSelectors.any())
                .build();
    }
}
