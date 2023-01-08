package com.backend.todo.dto

import com.backend.todo.shared.IDTO

data class TodoListResponseDTO(
  val pending: MutableList<TodoItemDTO>,
  val completed: MutableList<TodoItemDTO>
):IDTO