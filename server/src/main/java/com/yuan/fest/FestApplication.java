package com.yuan.fest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.yuan.fest.mapper")
public class FestApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FestApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(FestApplication.class);
        builder.application().setAdditionalProfiles("pro");
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
