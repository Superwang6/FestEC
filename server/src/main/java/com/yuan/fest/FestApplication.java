package com.yuan.fest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yuan.fest.mapper")
public class FestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FestApplication.class, args);
    }

}
