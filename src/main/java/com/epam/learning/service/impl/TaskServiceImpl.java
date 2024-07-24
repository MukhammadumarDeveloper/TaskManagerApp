package com.epam.learning.service.impl;

import com.epam.learning.dto.TaskDto;
import com.epam.learning.entity.TaskEntity;
import com.epam.learning.exeption.TaskNotFoundException;
import com.epam.learning.mapper.TaskMapper;
import com.epam.learning.repository.TaskRepository;
import com.epam.learning.service.TaskService;
import com.epam.learning.utils.DateTimeUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    @Transactional
    public String createTask(TaskDto taskDto) {
        if (taskDto != null) {
            taskDto.setCreatedDate(LocalDateTime.now()
                    .format(DateTimeFormatter
                            .ofPattern("yyyy-MM-dd HH:mm:ss")));

            TaskEntity taskEntity = TaskMapper.dtoToEntity(taskDto);


            taskRepository.save(taskEntity);
            return "Task created";
        }
        return "Task is null";
    }

    @Override
    @Transactional
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        TaskEntity taskEntity1 = taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() ->  new TaskNotFoundException(id));

        taskDto.setId(taskEntity1.getId());
        taskDto.setCreatedDate(DateTimeUtils.convertDateToString(taskEntity1.getCreateDate()));

        TaskEntity newTaskEntity = TaskMapper.dtoToEntity(taskDto);

        taskRepository.save(newTaskEntity);

        return TaskMapper.entityToDto(newTaskEntity);
    }

    @Override
    @Transactional
    public String deleteTask(Integer id) {
        TaskEntity taskEntity = taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskEntity.setDeleteDate(LocalDateTime.now());
        taskEntity.setIsDeleted(true);
        return "Task with ID: " + id + "was deleted successfully";
    }

    @Override
    @Transactional
    public TaskDto getTask(Integer id) {
        TaskEntity taskEntity = taskRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return TaskMapper.entityToDto(taskEntity);
    }

    @Override
    @Transactional
    public List<TaskDto> getAllTask() {
        List<TaskEntity> taskEntities = taskRepository.findAllByIsDeletedFalse();

        return taskEntities.stream().map(TaskMapper::entityToDto).collect(Collectors.toList());
    }
}
