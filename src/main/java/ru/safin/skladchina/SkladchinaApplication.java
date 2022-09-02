package ru.safin.skladchina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SkladchinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkladchinaApplication.class, args);
    }

}
