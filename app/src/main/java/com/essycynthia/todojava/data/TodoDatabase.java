package com.essycynthia.todojava.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

    private static volatile TodoDatabase todoDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TodoDatabase getDatabase(final Context context) {
        if (todoDatabase == null) {
            synchronized (TodoDatabase.class) {
                if (todoDatabase == null) {
                    todoDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                    TodoDatabase.class, "Todo")
                            .build();
                }
            }
        }
        return todoDatabase;
    }

}