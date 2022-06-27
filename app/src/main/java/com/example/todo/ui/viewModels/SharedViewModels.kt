package com.example.todo.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.data.models.TodoTask
import com.example.todo.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModels @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    private val _allTasks = MutableStateFlow<List<TodoTask>>(emptyList())

    val allTasks: StateFlow<List<TodoTask>> = _allTasks


    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value=it
            }
        }
    }
}