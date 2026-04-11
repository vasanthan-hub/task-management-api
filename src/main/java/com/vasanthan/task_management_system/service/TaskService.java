package com.vasanthan.task_management_system.service;


import com.vasanthan.task_management_system.dto.TaskRequestDto;
import com.vasanthan.task_management_system.dto.TaskResponseDto;
import com.vasanthan.task_management_system.entity.Task;
import com.vasanthan.task_management_system.exception.ResourceNotFoundException;
import com.vasanthan.task_management_system.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponseDto createTask(TaskRequestDto dto) {
        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(dto.getStatus() != null ? dto.getStatus() : Task.Status.PENDING)
                .priority(dto.getPriority() != null ? dto.getPriority() : Task.Priority.MEDIUM)
                .build();

        task = taskRepository.save(task);
        log.info("Created new task with id: {}", task.getId());

        return toDto(task);
    }

    public List<TaskResponseDto> getAllTasks(int page, int size) {
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(page, size));
        return tasks.stream().map(this::toDto).toList();
    }

    public TaskResponseDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return toDto(task);
    }

    public List<TaskResponseDto> getTasksByStatus(Task.Status status) {
        return taskRepository.findByStatus(status).stream().map(this::toDto).toList();
    }

    public List<TaskResponseDto> getTasksByPriority(Task.Priority priority) {
        return taskRepository.findByPriority(priority).stream().map(this::toDto).toList();
    }

    public List<TaskResponseDto> searchTasks(String keyword) {
        return taskRepository.searchByKeyword(keyword).stream().map(this::toDto).toList();
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());

        task = taskRepository.save(task);
        log.info("Updated task with id: {}", id);

        return toDto(task);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
        log.info("Deleted task with id: {}", id);
    }

    private TaskResponseDto toDto(Task task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .priority(task.getPriority())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}
