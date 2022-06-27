package com.example.todo.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todo.util.Constants.DATABASE_NAME
import com.example.todo.util.Constants.DATABASE_TABLE

//Entity tells roomDB this data-class will be a table
@Entity(tableName = DATABASE_TABLE)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
