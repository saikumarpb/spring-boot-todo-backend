package com.backend.todo.service

import com.backend.todo.dto.ResponseTodoListDTO
import com.backend.todo.model.Todo

interface TodoService {
  fun findAll(): ResponseTodoListDTO
  fun saveTodoItem(item:Todo)
  fun deleteTodoItem(id:Long)
}