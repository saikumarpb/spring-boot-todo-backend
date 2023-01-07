package com.backend.todo.dto

data class ResponseTodoListDTO(
  val pending: MutableList<TodoItem>,
  val completed: MutableList<TodoItem>
)

data class TodoItem(
  val id: Long,
  val text: String
)