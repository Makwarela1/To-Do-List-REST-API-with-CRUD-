package org.example.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ToDoListRequest(
        @NotBlank (message = "To Do List name is required")
        @Size(max = 255 , message = "Name of the To Do List must not exceed 255 characters")
        String todolistName,

        @NotBlank (message = "Task is required")
        @Size(max = 255 , message = "Task must not exceed 255 characters")
        String task,

        @NotBlank (message = "Status of task is required")
        @Size(max = 255 , message = "Status of the task must not exceed 255 characters")
        String status,

        @JsonFormat (pattern = "yyyy-MM-dd HH:mm")
        @NotBlank (message = "Due date is required")
        @Size(max = 6 , message = "Due date must not exceed 6 characters")
        String dueDate
        )
{

}