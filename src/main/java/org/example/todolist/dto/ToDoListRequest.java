package org.example.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.example.todolist.entity.Status;

import java.time.LocalDateTime;

public record ToDoListRequest(
        @NotBlank (message = "To Do List name is required")
        @Size(max = 255 , message = "Name of the To Do List must not exceed 255 characters")
        String todolistName,

        @NotBlank (message = "Task is required")
        @Size(max = 255 , message = "Task must not exceed 255 characters")
        String task,

        @NotBlank (message = "Status of task is required")
        @Size(max = 255 , message = "Status of the task must not exceed 255 characters")
        Status status,

        @JsonFormat (pattern = "yyyy-MM-dd HH:mm")
        @NotBlank (message = "Due date is required")
        @Size(max = 6 , message = "Due date must not exceed 6 characters")
        LocalDateTime dueDate
        )
{

}