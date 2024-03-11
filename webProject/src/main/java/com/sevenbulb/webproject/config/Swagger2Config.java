package com.sevenbulb.webproject.config;

import com.sevenbulb.webproject.entity.AdminUser;
import com.sevenbulb.webproject.entity.AdminUserToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {

        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> swaggerParams = new ArrayList<Parameter>();
        tokenParam.name("token").description("用户认证信息")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        swaggerParams.add(tokenParam.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(AdminUser.class, AdminUserToken.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sevenbulb.webproject.api"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(swaggerParams);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-api文档")
                .description("swagger文档 by hy")
                .version("1.0")
                .build();
    }
}

