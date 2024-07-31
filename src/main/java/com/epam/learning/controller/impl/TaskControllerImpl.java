package com.epam.learning.controller.impl;

import com.epam.learning.controller.TaskController;
import com.epam.learning.dto.TaskDto;
import com.epam.learning.exeption.FieldValidationException;
import com.epam.learning.exeption.InvalidValidationException;
import com.epam.learning.exeption.TaskNotFoundException;
import com.epam.learning.service.TaskService;
import com.epam.learning.utils.FieldValidationHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tasks")
@AllArgsConstructor
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;
    @Override
    @PostMapping
    public ResponseEntity<String> createTask(@Valid TaskDto taskDto, BindingResult result) {
        try {
            //    Main purpose of this utility is returning meaningfull error messages to the frontend
            String errors = FieldValidationHandler.validateFields(result);
            if (errors != null) {
                throw new FieldValidationException(errors);
            }
            return ResponseEntity.ok(taskService.createTask(taskDto));
        } catch (FieldValidationException | InvalidValidationException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }



    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask( @PathVariable Integer id, @Valid TaskDto taskDto, BindingResult result) {
        try {
//            Giving meaningfull error messages to the users
            String errors = FieldValidationHandler.validateFields(result);
            if (errors != null) {
                throw new FieldValidationException(errors);
            }
            return ResponseEntity.ok(taskService.updateTask(id, taskDto));
        } catch (TaskNotFoundException taskNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (FieldValidationException  e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (InvalidValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(taskService.deleteTask(id));
        } catch (TaskNotFoundException taskNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Integer id) {
        try {
            TaskDto task = taskService.getTask(id);
            return ResponseEntity.ok(task);
        } catch (TaskNotFoundException taskNotFoundException) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
}
