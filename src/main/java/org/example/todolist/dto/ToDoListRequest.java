package org.example.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.todolist.entity.Status;

import java.time.LocalDateTime;

public record ToDoListRequest(
        @NotBlank (message = "To Do List name is required")
        @Size(max = 255 , message = "Name of the To Do List must not exceed 255 characters")
        String toDoListName,

        @NotBlank (message = "Task is required")
        @Size(max = 255 , message = "Task must not exceed 255 characters")
        String task,

        @NotNull (message = "Status is required")
        Status status,

        @JsonFormat (pattern = "yyyy-MM-dd HH:mm")
        @NotNull (message = "Due date is required")
        LocalDateTime dueDate
        )
{

}