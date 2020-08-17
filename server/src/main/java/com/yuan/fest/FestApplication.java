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
        //指定配置文件为后缀pro的
        builder.application().setAdditionalProfiles("pro");
        //不启动banner
        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
