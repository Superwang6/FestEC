package com.yuan.fest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class FestAppliactionInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.application().setAdditionalProfiles("pro");
        return builder.sources(FestApplication.class);
    }
}
