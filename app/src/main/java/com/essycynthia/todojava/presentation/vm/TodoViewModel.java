package com.essycynthia.todojava.presentation.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.essycynthia.todojava.data.Todo;
import com.essycynthia.todojava.domain.TodoRepository;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private TodoRepository todoRepository;
    private LiveData<List<Todo>> allTodos;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        todoRepository = new TodoRepository(application);
        allTodos = todoRepository.getAllTodos();
    }

    public LiveData<List<Todo>> getAllTodos() {
        return allTodos;
    }

    public void insertTodo(Todo todo) {
        todoRepository.insertTodo(todo);
    }

    public void deleteTodo(Todo todo) {
        todoRepository.deleteTodo(todo);
    }

     public LiveData<Todo> getTodoById(Integer id) {
         return todoRepository.getTodoById(id);
     }
}
