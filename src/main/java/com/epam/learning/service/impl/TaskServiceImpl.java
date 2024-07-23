package com.epam.learning.service.impl;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Override
    public String createTask(TaskDto taskDto) {

    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {

    }

    @Override
    public String deleteTask(Integer id) {

    }

    @Override
    public TaskDto getTask(Integer id) {

    }

    @Override
    public List<TaskDto> getAllTask() {

    }
}
