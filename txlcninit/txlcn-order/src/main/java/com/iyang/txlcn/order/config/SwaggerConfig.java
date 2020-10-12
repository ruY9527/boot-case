package com.iyang.txlcn.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Yang
 * 当前服务 : txlcn-init
 * @date 2020/10/12 / 17:37
 */

@Configuration
public class SwaggerConfig {

    public ApiInfo createAI(){
        ApiInfo apiInfo=new ApiInfoBuilder().title("基于Dubbo实现的数据接口").
                description("基于Dubbo实现的二维码名片的一套后端接口").
                contact(new Contact("Feri","http://www.17feri.top","xingfei_work@163.com")).build();
        return apiInfo;
    }
    //创建Swagger扫描信息
    @Bean
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createAI()).select().
                apis(RequestHandlerSelectors.basePackage("com.iyang.txlcn.order.controller")).build();
    }

}
