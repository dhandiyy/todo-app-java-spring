package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
    
}
