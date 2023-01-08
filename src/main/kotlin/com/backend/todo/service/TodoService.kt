package com.backend.todo.service

import com.backend.todo.dto.TodoListResponseDTO
import com.backend.todo.model.Todo

interface TodoService {
  fun findAll(): TodoListResponseDTO
  fun saveTodoItem(item:Todo)
  fun deleteTodoItem(id:Long)
}