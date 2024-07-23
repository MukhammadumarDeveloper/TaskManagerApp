package com.epam.learning.mapper;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity dtoToEntity(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity();
        dtoToEntity(taskDto, taskEntity);
        return taskEntity;
    }

    public TaskEntity dtoToEntity(TaskDto taskDto, TaskEntity taskEntity) {

    }

    public TaskDto entityToDto(TaskEntity taskEntity) {

    }
}
