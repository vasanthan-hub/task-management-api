package com.vasanthan.task_management_system.exception;


import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(LocalDateTime timestamp, String message, Map<String, String> details) {}
