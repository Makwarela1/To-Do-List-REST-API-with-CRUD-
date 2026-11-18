package org.example.todolist.controllers;

import jakarta.validation.Valid;
import org.example.todolist.dto.ToDoListResponse;
import org.example.todolist.dto.ToDoListRequest;
import org.example.todolist.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    @GetMapping
    public ResponseEntity <List<ToDoListResponse>> getAllTasks (){
         return ResponseEntity.ok(taskService.getAllTasks());
    }

    // UPDATE TASK
    @PutMapping("/{task_id}")
    public ResponseEntity<ToDoListResponse> updateTask(
            @PathVariable Long task_id,
            @Valid @RequestBody ToDoListRequest request) {

        ToDoListResponse response = taskService.updateTask(task_id, request);
        return ResponseEntity.ok(response);
    }

    // DELETE TASK
    @DeleteMapping("/{task_id}")
    public ResponseEntity <Void> deleteTask (@PathVariable Long task_id){
        taskService.deleteTask(task_id);
        return ResponseEntity.noContent().build();
    }

}
