package com.fstg.bookeraccountservice;

import com.fstg.bookeraccountservice.infra.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class BookerAccountServiceApplication implements CommandLineRunner {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(BookerAccountServiceApplication.class, args);
    }

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        // TODO document why this method is empty
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }


}
