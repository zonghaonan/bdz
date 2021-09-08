package com.example.bdz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2    //开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(Environment environment){
        //设置要显示的swagger环境
        Profiles profiles= Profiles.of("dev","test");
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("Authorization").description("认证信息")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        //判断是否处在自己设置的环境中
        //boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("bdz")
                //是否启用swagger。默认为true
//                .enable(flag)
                .select()
                //RequestHandlerSelectors:配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any:扫描全部
                //none:不扫描
                //withClassAnnotation:扫描类上的注解，参数为注解的反射对象
                //withMethodAnnotation:扫描方法上的注解，参数为注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.example.bdz"))
                //过滤路径
//                .paths(PathSelectors.ant("/zhn/*"))
                .build().globalOperationParameters(pars);
    }

    public ApiInfo getApiInfo(){
        Contact contact = new Contact("bdz", "http://www.baidu.com", "1621176127@qq.com");
        return new ApiInfo(
                "bdz的swagger文档",
                "欢迎阅读此文档",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
