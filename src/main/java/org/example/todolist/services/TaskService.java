package org.example.todolist.services;


import org.example.todolist.dto.ToDoListRequest;
import org.example.todolist.dto.ToDoListResponse;
import org.example.todolist.entity.ToDoList;
import org.example.todolist.exceptions.ResourceNotFoundException;
import org.example.todolist.exceptions.DuplicateResourceException;
import org.example.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final ToDoListRepository toDoListRepository;

    public TaskService(ToDoListRepository toDoListRepository){
        this.toDoListRepository = toDoListRepository;
    }

    // CREATE
    @Transactional
    public ToDoListResponse createTask (ToDoListRequest request){
        if (toDoListRepository.existsByToDoListName (request.toDoListName())){
            throw new DuplicateResourceException("A to list with that name already exists");
        }

    ToDoList toDoList = new ToDoList();
    toDoList.setToDoListName(request.toDoListName());
    toDoList.setTask(request.task());
    toDoList.setStatus(request.status());
    toDoList.setDueDate(request.dueDate());

    ToDoList saveTask = toDoListRepository.save(toDoList);
    return mapToResponse(saveTask);
    }

    //READ TASKS
    @Transactional (readOnly = true)
    public List<ToDoListResponse> getAllTasks () {
        return toDoListRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    //UPDATE TASK
    @Transactional
    public ToDoListResponse updateTask (Long task_id, ToDoListRequest request){
        ToDoList toDoList = findTaskOrThrow(task_id);
        if (toDoListRepository.existsByToDoListName(request.task())){
            throw new DuplicateResourceException("That task already exists");
        }

        toDoList.setToDoListName(request.toDoListName());
        toDoList.setTask(request.task());
        toDoList.setStatus(request.status());
        toDoList.setDueDate(request.dueDate());

        ToDoList updatedTask = toDoListRepository.save(toDoList);
        return mapToResponse(updatedTask);

    }

    //DELETE TASK
    @Transactional
    public void deleteTask(Long task_id){
        ToDoList toDoList = findTaskOrThrow(task_id);
        ToDoList deletedTask = toDoListRepository.save(toDoList);
        toDoListRepository.delete(deletedTask);
    }

    private ToDoList findTaskOrThrow (Long task_id){
        return toDoListRepository.findById(task_id).orElseThrow (() -> new ResourceNotFoundException("Task with that Id can not be foud: " + task_id));
    }

    private ToDoListResponse mapToResponse (ToDoList toDoList) {
        return new ToDoListResponse(
                toDoList.getTask_id(),
                toDoList.getTask(),
                toDoList.getStatus(),
                toDoList.getDueDate(),
                toDoList.getToDoListName()
        );
    }
}
