package com.essycynthia.todojava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodo(Todo todo);

    @Delete
    void deleteTodo(Todo todo);

    @Query("SELECT * FROM Todo where id = :id ")
    LiveData<Todo> getTodoById(Integer id);

    @Query("SELECT * FROM Todo ")
    LiveData<List<Todo>> getAllTodos();
}
