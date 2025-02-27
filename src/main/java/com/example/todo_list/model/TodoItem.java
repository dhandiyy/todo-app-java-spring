package com.example.todo_list.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "todolist_id")
    private TodoList todoList;
    
}
