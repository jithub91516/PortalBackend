package com.example.ahnlabportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.example.ahnlabportal", "com.example.ahnlabportal.OracleUserCRUDTest"})
@EntityScan(basePackages = {"com.example.ahnlabportal.OracleUserCRUDTest"})
public class AhnlabPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AhnlabPortalApplication.class, args);


        System.out.println("application starts");
    }

}
