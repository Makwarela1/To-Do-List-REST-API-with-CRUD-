package org.example.todolist.dto;

import org.example.todolist.entity.Status;

import java.time.LocalDateTime;

public record ToDoListResponse(
        Long task_id,
        String task,
        Status status,
        LocalDateTime dueDate
) {
}
