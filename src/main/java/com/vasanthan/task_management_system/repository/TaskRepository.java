package com.vasanthan.task_management_system.repository;

import com.vasanthan.task_management_system.entity.Task;
import com.vasanthan.task_management_system.entity.Task.Priority;
import com.vasanthan.task_management_system.entity.Task.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(Status status);
    List<Task> findByPriority(Priority priority);

    @Query("SELECT t FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchByKeyword(String keyword);
}
