package com.fstg.bookeraccountservice;

import com.fstg.bookeraccountservice.infra.dao.UserDao;
import com.fstg.bookeraccountservice.infra.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.Stream;


@SpringBootApplication
@EnableJpaAuditing
public class BookerAccountServiceApplication implements CommandLineRunner {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(BookerAccountServiceApplication.class, args);
    }

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("yassir", "hiba", "amadou").forEach(username -> {
            User user = new User();
            user.setUsername(username);
            User u = this.userDao.save(user);
        });
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }


}
