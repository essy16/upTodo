package com.essycynthia.todojava.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.essycynthia.countries.R;
import com.essycynthia.todojava.data.Todo;
import com.essycynthia.todojava.presentation.vm.TodoViewModel;

public class AddTodoActivity extends AppCompatActivity {

    private TodoViewModel todoViewModel;
    private EditText enterTitleEditText;
    private EditText enterDescEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        enterTitleEditText = findViewById(R.id.enterTitle);
        enterDescEditText = findViewById(R.id.enterDesc);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered title and description
                String title = enterTitleEditText.getText().toString().trim();
                String description = enterDescEditText.getText().toString().trim();

                // Check if both title and description are not empty
                if (!title.isEmpty() && !description.isEmpty()) {
                    // Create a new Todo object
                    Todo newTodo = new Todo(null, title, description, false);

                    // Insert the new Todo using the ViewModel
                    todoViewModel.insertTodo(newTodo);

                    // Finish the activity or navigate back
                    Intent goBack = new Intent(AddTodoActivity.this,MainActivity.class);
                    startActivity(goBack);
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(AddTodoActivity.this,MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}
