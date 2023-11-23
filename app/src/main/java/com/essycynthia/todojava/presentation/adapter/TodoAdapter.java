package com.essycynthia.todojava.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.essycynthia.countries.R;
import com.essycynthia.todojava.data.Todo;
import com.essycynthia.todojava.domain.TodoClick;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todoList;
    private final TodoClick listener;

    public TodoAdapter(List<Todo> todoList, TodoClick listener) {
        this.todoList = todoList != null ? new ArrayList<>(todoList) : new ArrayList<>();
        this.listener = listener;
    }

    public void updateTodoList(List<Todo> newTodoList) {
        if (newTodoList != null) {
            todoList.clear();
            todoList.addAll(newTodoList);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo, parent, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo currentTodo = todoList.get(position);
        holder.todoTitle.setText(currentTodo.getTitle());
        holder.todoDesc.setText(currentTodo.getDescription());
        holder.checkBox.setChecked(currentTodo.getDone());

        // Handle item click event
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClicked(currentTodo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private final TextView todoTitle;
        private final TextView todoDesc;
        private final CheckBox checkBox;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            todoTitle = itemView.findViewById(R.id.todoTitle);
            todoDesc = itemView.findViewById(R.id.todoDesc);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
