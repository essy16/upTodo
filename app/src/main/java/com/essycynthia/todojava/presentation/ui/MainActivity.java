package com.essycynthia.todojava.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.essycynthia.countries.R;
import com.essycynthia.todojava.data.Todo;
import com.essycynthia.todojava.domain.TodoClick;
import com.essycynthia.todojava.presentation.adapter.TodoAdapter;
import com.essycynthia.todojava.presentation.vm.TodoViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoClick {

    private TodoViewModel todoViewModel;
    private TodoAdapter todoAdapter;
    private List<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        // Initialize RecyclerView and Adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        todoAdapter = new TodoAdapter(todos,this);
        recyclerView.setAdapter(todoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Observe the LiveData in your ViewModel and update the adapter when the data changes
        todoViewModel.getAllTodos().observe(this, todos -> {
            // Update the UI
            todoAdapter.updateTodoList(todos);
        });

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            Intent addTodo = new Intent(MainActivity.this,AddTodoActivity.class);
            startActivity(addTodo);
        });
    }

    @Override
    public void onItemClicked(Todo todo) {
        Intent addTodo = new Intent(MainActivity.this,AddTodoActivity.class);
        startActivity(addTodo);
    }
}
