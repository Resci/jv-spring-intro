package com.mate;

import com.mate.config.AppConfig;
import com.mate.model.User;
import com.mate.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        User firstUser = new User();
        firstUser.setName("Bob");
        firstUser.setLastName("Robson");
        userService.add(firstUser);
        User secondUser = new User();
        secondUser.setName("Alice");
        secondUser.setLastName("Alyson");
        userService.add(secondUser);
        userService.listUsers().forEach(System.out::println);
    }
}
