package com.example.todo.data

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.todo.data.models.TodoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    //flow: asyncrornus data stream
    fun getAllTasks(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun SelectedTask(taskId: Int): Flow<TodoTask>

    @Insert(onConflict = IGNORE)
    suspend fun addTask(todoTask: TodoTask)

    @Update
    suspend fun updateTask(todoTask: TodoTask)

    @Delete
    suspend fun deleteTask(todoTask: TodoTask)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery ")
    fun searchDatabase(searchQuery: String): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END ")
    fun sortByLowPriority(): Flow<List<TodoTask>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END ")
    fun sortByHighPriority(): Flow<List<TodoTask>>
}