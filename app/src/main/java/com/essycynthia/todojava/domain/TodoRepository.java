package com.essycynthia.todojava.domain;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.essycynthia.todojava.data.Todo;
import com.essycynthia.todojava.data.TodoDao;
import com.essycynthia.todojava.data.TodoDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class TodoRepository {
    private TodoDao todoDao;
    private LiveData<List<Todo>> allTodos;
    private ExecutorService executorService;

    public TodoRepository(Context context) {
        TodoDatabase database = TodoDatabase.getDatabase(context);
        todoDao = database.todoDao();
        allTodos = todoDao.getAllTodos();
        executorService = TodoDatabase.databaseWriteExecutor;
    }

    public LiveData<List<Todo>> getAllTodos() {
        return allTodos;
    }

    public void insertTodo(final Todo todo) {
        executorService.execute(() -> todoDao.insertTodo(todo));
    }

    public void deleteTodo(final Todo todo) {
        executorService.execute(() -> todoDao.deleteTodo(todo));
    }

    public LiveData<Todo> getTodoById(Integer id) {
        // You may need to modify this if you want to observe changes to a specific Todo by ID
        return todoDao.getTodoById(id);
    }
}
