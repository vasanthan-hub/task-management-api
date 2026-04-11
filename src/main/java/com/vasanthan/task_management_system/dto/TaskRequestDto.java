package com.vasanthan.task_management_system.dto;

import com.vasanthan.task_management_system.entity.Task.Priority;
import com.vasanthan.task_management_system.entity.Task.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private Status status;
    private Priority priority;
}
