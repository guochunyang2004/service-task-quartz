package com.mycloud.service.task;

import com.mycloud.service.task.config.app.AppConfig;
import com.mycloud.service.task.config.swagger2.SwaggerConfiguration;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("定时任务")
@RestController
@SpringBootApplication
@MapperScan({"com.mycloud.service.task.models.dao"})
@Import({SwaggerConfiguration.class})
public class ServiceTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTaskApplication.class, args);
    }
//    @Bean
////    public AppConfig appConfig() {
////        return new AppConfig();
////    }


    @GetMapping("/test")
    public String test(){
        return "测试";
    }
}
