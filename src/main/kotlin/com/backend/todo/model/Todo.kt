package com.backend.todo.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Todo(
  @Id
  val id: Long,
  val text: String,
  val isPending: Boolean

){
  private constructor() : this(1, "", true)
}