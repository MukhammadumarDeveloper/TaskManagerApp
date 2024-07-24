package com.epam.learning.repository;

import com.epam.learning.entity.TaskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {
    @Query("SELECT e FROM TaskEntity e WHERE e.title = :title")
    TaskEntity getTaskByTitle(@Param("title") String title);

    @Query("SELECT e FROM TaskEntity e WHERE e.id = :id AND e.isDeleted = false")
    Optional<TaskEntity> findByIdAndIsDeletedFalse(@Param("id") long id);

    @Query("SELECT e FROM TaskEntity e WHERE e.isDeleted = false")
    List<TaskEntity> findAllByIsDeletedFalse();
}
