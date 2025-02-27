package com.example.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_list.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    
}
