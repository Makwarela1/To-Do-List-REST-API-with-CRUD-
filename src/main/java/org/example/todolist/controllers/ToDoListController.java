package org.example.todolist.controllers;

import jakarta.validation.Valid;
import org.example.todolist.dto.ToDoListResponse;
import org.example.todolist.entity.ToDoList;
import org.example.todolist.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.todolist.services.TaskService;
import org.example.todolist.dto.ToDoListResponse;
import org.example.todolist.dto.ToDoListRequest;

import java.util.List;


@RestController
@RequestMapping("/api/v1/todolist")
public class ToDoListController {
    private final TaskService taskService;

    public ToDoListController (TaskService taskService){
        this.taskService = taskService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity <ToDoListResponse>  createTask (@Valid @RequestBody ToDoListRequest request){
        ToDoListResponse response = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // READ ALL
    @GetMapping ("/todolist")
    public ResponseEntity <List<ToDoListResponse>> getAllTasks ()

    //READ ONE
}
