package com.example.todo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.data.models.TodoTask

@Database(entities = [TodoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun toDoDao():ToDoDao
}
