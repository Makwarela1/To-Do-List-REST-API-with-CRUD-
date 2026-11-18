package org.example.todolist.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table (name = "ToDo_List")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long task_id;
    @Column (name = "task", nullable = false)
    private String task;
    @Enumerated(EnumType.STRING)
    @Column (name = "status", nullable = false)
    private Status status ;
    @Column (name = "dueDate", nullable = false)
    private LocalDateTime dueDate;
    @Column (name = "todolist_name", nullable = false)
    private String todolistName;
}
