package com.example.demo.config;


import com.example.demo.component.MyResolver;
import com.example.demo.component.myInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
    }



    //注册拦截器
    @Override

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new myInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/","/user/login","/asserts/img/bootstrap-solid.svg","/asserts/css/signin.css","/webjars/bootstrap/4.0.0/css/bootstrap.css");

    }

    @Bean
    public LocaleResolver localeResolver(){

        return new MyResolver();
    }

    /*@Bean
        public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
            WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
                public void addViewControllers(ViewControllerRegistry registry){
                    registry.addViewController("/").setViewName("login");
                    registry.addViewController("/index").setViewName("login");
                }
            };
            return adapter;
        }*/
}
