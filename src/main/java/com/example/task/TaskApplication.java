package com.example.task;

import com.example.task.entity.WorkItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }


/*    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            WorkItem item = new WorkItem(1L, LocalDateTime.now(), "baslik", "aciklama", false);
            WorkItem item2 = new WorkItem(7L, LocalDateTime.now(), "titleeeeeee", "descriptionnnnnnn", false);

            System.out.println(item);
            System.out.println(item2);

        };
    }*/

}
