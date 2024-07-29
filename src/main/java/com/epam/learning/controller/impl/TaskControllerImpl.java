package com.epam.learning.controller.impl;

import com.epam.learning.controller.TaskController;
import com.epam.learning.dto.TaskDto;
import com.epam.learning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;
    @Override
    @PostMapping
    public ResponseEntity<String> createTask(TaskDto taskDto) {
        return ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Integer id, TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDto));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    // @Override
    // public ResponseEntity<String> deleteTask(Long id) {
    //     return null;
    // }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
}
