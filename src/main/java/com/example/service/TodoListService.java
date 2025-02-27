package com.example.service;
import com.example.model.TodoItem;
import com.example.model.TodoList;
import com.example.repository.TodoItemRepository;
import com.example.repository.TodoListRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoItemRepository todoItemRepository;
    private final TodoListRepository todoListRepository;

    public List<TodoList> getAllTodoList(){
        return todoListRepository.findAll();
    }

    public Optional<TodoList> getTodoListById(Long id){
        return todoListRepository.findById(id);
    }

    public TodoList createTodoList(TodoList todoList){
        return todoListRepository.save(todoList);
    }

    public void deleteTodoList(Long id){
        todoListRepository.deleteById(id);
    }

    public TodoItem addItemToTodoList(Long todoListId, TodoItem todoItem){
        return todoListRepository.findById(todoListId).map(todoList -> {
            todoItem.setTodoList(todoList);
            return todoItemRepository.save(todoItem);

        }).orElseThrow(() -> new RuntimeException("TodoList not found"));
    }

    public void deleteTodoItem(Long todoItemId){
        todoItemRepository.deleteById(todoItemId);
    }

    public TodoItem updateTodoItemStatus(Long todoItemId, boolean completed){
        return todoItemRepository.findById(todoItemId).map(item -> {
            item.setCompleted(completed);
            return todoItemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    
}
