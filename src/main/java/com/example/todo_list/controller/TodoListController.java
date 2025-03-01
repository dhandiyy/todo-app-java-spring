package com.example.todo_list.controller;

import com.example.todo_list.model.TodoItem;
import com.example.todo_list.model.TodoList;
import com.example.todo_list.service.TodoListService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
@RequiredArgsConstructor
public class TodoListController {
    private final TodoListService todoListService;

    @GetMapping()
    public List<TodoList> getAllTodoList(){
        return todoListService.getAllTodoList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable Long id){
        return todoListService.getTodoListById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id){
        return todoListService.getTodoItemById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public TodoList createTodoList(@RequestBody TodoList todoList){
        return todoListService.createTodoList(todoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Long id){
        todoListService.deleteTodoList(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/items")
    public TodoItem addItemToTodoList(@PathVariable Long id, @RequestBody TodoItem todoItem){
        return todoListService.addItemToTodoList(id, todoItem);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        todoListService.deleteTodoItem(itemId);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/items/{itemId}/status")
    public TodoItem updateItemStatus(@PathVariable Long itemId, @RequestParam boolean completed) {
        return todoListService.updateTodoItemStatus(itemId, completed);
    }
} 
