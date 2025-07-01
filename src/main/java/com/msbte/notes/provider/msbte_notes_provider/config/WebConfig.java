package com.msbte.notes.provider.msbte_notes_provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // ✅ Get absolute path of project directory
        String uploadPath = System.getProperty("user.dir") + "/uploads/";

        // ✅ Serve /uploads/** URLs from filesystem
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath);
    }
}
