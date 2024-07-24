package com.epam.learning.mapper;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.entity.TaskEntity;
import com.epam.learning.utils.DateTimeUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static TaskEntity dtoToEntity(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity();
        dtoToEntity(taskDto, taskEntity);
        return taskEntity;
    }

    public static TaskEntity dtoToEntity(TaskDto taskDto, TaskEntity taskEntity) {
        taskEntity.setId(taskDto.getId());
        taskEntity.setTitle(taskDto.getTitle());
        taskEntity.setContent(taskDto.getContent());
        taskEntity.setStatus(taskDto.getStatus());
        taskEntity.setPriority(taskDto.getPriority());
        taskEntity.setDueDate(DateTimeUtils.convertStringToDate(taskDto.getDueDate()));
        return taskEntity;
    }

    public static TaskDto entityToDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .content(taskEntity.getContent())
                .status(taskEntity.getStatus())
                .priority(taskEntity.getPriority())
                .dueDate(DateTimeUtils.convertDateToString(taskEntity.getDueDate()))
                .build();
    }
}
