package com.essycynthia.todojava.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Todo")
public class Todo {
    @PrimaryKey
    @NonNull
    Integer id;
    String Title;
    String Description;
    Boolean isDone;
    public Todo() {
    }
    public Todo(@NonNull Integer id, String title, String description, Boolean isDone) {
        this.id = id;
        this.Title = title;
        this.Description = description;
        this.isDone = isDone;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
