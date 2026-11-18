package org.example.todolist.repository;
import org.example.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

    boolean existsByToDoListName (String toDoListName);


}
