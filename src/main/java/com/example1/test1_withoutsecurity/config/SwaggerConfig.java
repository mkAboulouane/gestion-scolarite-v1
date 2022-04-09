package com.example1.test1_withoutsecurity.config;

//import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

//@Configuration
//@EnableSwagger2
public  class SwaggerConfig {


        @Bean
        public Docket api() {

            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
                    .build();

        }
    }


    //    @Bean
//    public Docket khalil(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
//                .build().apiInfo(getApiInfo());
//    }
//    private ApiInfo getApiInfo(){
//        return new ApiInfoBuilder()
//                .title("gestion scolarite")
//                .version("1.0")
//                .description("bala bka s")
//                .contact(new Contact("sfs","http://khalil.com","aboulouanek@gmail.com"))
//                .license("sksm").build();
//
//    }