package com.backend.todo.service.impl

import com.backend.todo.dto.TodoListResponseDTO
import com.backend.todo.dto.TodoItemDTO
import com.backend.todo.model.Todo
import com.backend.todo.repository.TodoRepositorty
import com.backend.todo.service.TodoService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
  private val todoRepositorty: TodoRepositorty
) : TodoService {

  override fun findAll(): TodoListResponseDTO {
    val data = todoRepositorty.findAll() as List<Todo>
    val responseTodoList: TodoListResponseDTO = TodoListResponseDTO(
      mutableListOf(),
      mutableListOf()
    )
    data.forEach { item ->
      if (item.isPending) {
        responseTodoList.pending.add(TodoItemDTO(item.id, item.text))
      } else {
        responseTodoList.completed.add(TodoItemDTO(item.id, item.text))
      }
    }
    return responseTodoList
  }

  override fun saveTodoItem(item: Todo) {
    todoRepositorty.save(item)
    return
  }

  override fun deleteTodoItem(id: Long) {
    todoRepositorty.deleteById(id)
    return
  }
}
