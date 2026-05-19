package com.example.todoapp

import java.util.Date

data class Todo(
    var id: Int,
    var title: String,
    var createdAt: Date
)

fun getFakeTodos(): List<Todo>{
    return listOf<Todo>(
        Todo(1, "Wash the dishes", Date()),
        Todo(2, "Do the laundry", Date()),
        Todo(3, "Buy groceries", Date()),
        Todo(4, "Go for a walk", Date()),
        Todo(5, "Clean the house", Date()),
    )
}