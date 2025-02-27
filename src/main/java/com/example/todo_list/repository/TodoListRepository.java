package com.example.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_list.model.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long>{
    
}
