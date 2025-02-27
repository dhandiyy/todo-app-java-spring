package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long>{
    
}
