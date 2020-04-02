package org.viakiba.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class I18nApplication {

    public static void main(String[] args) {
        SpringApplication.run(I18nApplication.class, args);
    }

}

