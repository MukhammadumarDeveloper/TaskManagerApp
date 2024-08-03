package com.epam.learning.utils;

import com.epam.learning.TaskManagerApplication;
import com.epam.learning.dto.TaskDto;
import com.epam.learning.enums.Priority;
import com.epam.learning.enums.Status;
import com.epam.learning.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DbLoader {
    @Autowired
    private TaskService taskService;
    private Logger log = LoggerFactory.getLogger(TaskManagerApplication.class);

    @Bean
    public CommandLineRunner loadData() {
        return args -> {

            TaskDto taskDto = TaskDto.builder()
                    .title("yangicha")
                    .content("wwwwwwwwwwwwwwwwwwww")
                    .dueDate("2022-03-20 11:30:10")
                    .status(Status.DONE)
                    .priority(Priority.TOP)
                    .createdDate(DateTimeUtils.convertDateToString(LocalDateTime.now()))
                    .dueDate("2022-04-20 11:30:22")
                    .build();

            TaskDto taskDto2 = TaskDto.builder().id(2)
                    .title("shunchaki uzgardi")
                    .content("haha")
                    .dueDate("2028-08-01 18:30:22")
                    .createdDate(DateTimeUtils.convertDateToString(LocalDateTime.now()))
                    .status(Status.REVIEW)
                    .priority(Priority.MEDIUM)
                    .build();

            TaskDto taskDto4 = TaskDto.builder().id(2)
                    .title("yana bittasi")
                    .content("okokokokokokokok")
                    .dueDate("2029-05-02 21:40:22")
                    .createdDate(DateTimeUtils.convertDateToString(LocalDateTime.now()))
                    .status(Status.DONE)
                    .priority(Priority.LOW)
                    .build();

            // taskService.createTask(taskDto);
            // taskService.createTask(taskDto2);
            taskService.createTask(taskDto4);
            // taskService.deleteTask(3);
            // taskService.updateTask(4, taskDto2);

            // taskService.getAllTask().stream()
            // .forEach(task -> log.info("task with ID: " + task.getId() + "was created"));
            taskService.getAllTask().stream()
                    .forEach(task -> System.out.println("task name" + task.getTitle()));

        };
    }
}
