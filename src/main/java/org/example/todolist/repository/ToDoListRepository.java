package org.example.todolist.repository;
import org.springframework.stereotype.Repository;
import org.example.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ToDoListRepository extends JpaRepository <ToDoList, Long> {


}
