package com.example.project_agriculture;

import com.example.project_agriculture.cache.RedisConnectionFactory;
import com.example.project_agriculture.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectAgricultureApplication implements ApplicationRunner {
    @Autowired
    private RedisConfig redisConfig;

    public static void main(String[] args) {
        SpringApplication.run(ProjectAgricultureApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RedisConnectionFactory.init(redisConfig.getHost(), redisConfig.getPort(), null);
    }
}
