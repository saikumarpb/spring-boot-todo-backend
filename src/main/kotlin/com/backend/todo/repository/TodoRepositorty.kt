package com.backend.todo.repository

import com.backend.todo.model.Todo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepositorty:CrudRepository<Todo,Long> {
}