package com.vasanthan.task_management_system.controller;


import com.vasanthan.task_management_system.dto.TaskRequestDto;
import com.vasanthan.task_management_system.dto.TaskResponseDto;
import com.vasanthan.task_management_system.entity.Task.Priority;
import com.vasanthan.task_management_system.entity.Task.Status;
import com.vasanthan.task_management_system.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto dto) {
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Priority priority) {

        if (status != null) return ResponseEntity.ok(taskService.getTasksByStatus(status));
        if (priority != null) return ResponseEntity.ok(taskService.getTasksByPriority(priority));
        return ResponseEntity.ok(taskService.getAllTasks(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TaskResponseDto>> searchTasks(@RequestParam String keyword) {
        return ResponseEntity.ok(taskService.searchTasks(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id,
                                                      @Valid @RequestBody TaskRequestDto dto) {
        return ResponseEntity.ok(taskService.updateTask(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
