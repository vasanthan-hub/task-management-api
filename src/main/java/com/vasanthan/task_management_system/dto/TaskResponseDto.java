package com.vasanthan.task_management_system.dto;


import com.vasanthan.task_management_system.entity.Task.Priority;
import com.vasanthan.task_management_system.entity.Task.Status;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
