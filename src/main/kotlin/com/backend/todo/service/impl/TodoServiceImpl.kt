package com.backend.todo.service.impl

import com.backend.todo.dto.ResponseTodoListDTO
import com.backend.todo.dto.TodoItem
import com.backend.todo.model.Todo
import com.backend.todo.repository.TodoRepositorty
import com.backend.todo.service.TodoService
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
  private val todoRepositorty: TodoRepositorty
) : TodoService {

  override fun findAll(): ResponseTodoListDTO {
    val data = todoRepositorty.findAll() as List<Todo>
    val responseTodoList: ResponseTodoListDTO = ResponseTodoListDTO(
      mutableListOf(),
      mutableListOf()
    )
    data.forEach { item ->
      if (item.isPending) {
        responseTodoList.pending.add(TodoItem(item.id, item.text))
      } else {
        responseTodoList.completed.add(TodoItem(item.id, item.text))
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
