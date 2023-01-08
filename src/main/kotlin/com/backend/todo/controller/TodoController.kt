package com.backend.todo.controller

import com.backend.todo.dto.TodoListResponseDTO
import com.backend.todo.model.Todo
import com.backend.todo.routes.Routes
import com.backend.todo.service.TodoService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

// Allowed all the origin for development and testing.
@CrossOrigin(origins = ["*"])
@RestController
class TodoController(
  private val todoService: TodoService
){
  @GetMapping(Routes.getTodoList)
  fun getTodoList(): TodoListResponseDTO {
    return todoService.findAll()
  }

  @PostMapping(Routes.postTodoItem)
  fun postTodoItem(@RequestBody todoItem: Todo) {
    todoService.saveTodoItem(todoItem)
    return
  }

  @DeleteMapping(Routes.deleteTodoItem)
  fun deleteFromTodoList(@PathVariable("id") id: Long) {
    todoService.deleteTodoItem(id)
  }
}
