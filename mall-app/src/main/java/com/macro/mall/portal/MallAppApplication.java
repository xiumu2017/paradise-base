package com.macro.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Paradise
 */
@SpringBootApplication(scanBasePackages = "com.macro.mall")
public class MallAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAppApplication.class, args);
    }

}
