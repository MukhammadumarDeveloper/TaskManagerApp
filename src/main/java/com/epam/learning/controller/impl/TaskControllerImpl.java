package com.epam.learning.controller.impl;

import com.epam.learning.controller.TaskController;
import com.epam.learning.dto.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    @Override
    public ResponseEntity<String> createTask(TaskDto taskDto) {

    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Integer id, TaskDto taskDto) {

    }

    @Override
    public ResponseEntity<String> deleteTask(Integer id) {

    }

    @Override
    public ResponseEntity<TaskDto> getTask(Integer id) {

    }

    @Override
    public ResponseEntity<List<TaskDto>> getAllTask() {

    }
}
