package it.polarorb.databindingexample.mvvm.list;


import android.databinding.BaseObservable;

import java.text.SimpleDateFormat;

import it.polarorb.databindingexample.models.Todo;

public class TodoViewModel extends BaseObservable {
    Todo todo;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public TodoViewModel(Todo todo) {
        this.todo = todo;
    }

    public String getTitle() {
        return todo.getTitle();
    }

    public String getDate() {
        return simpleDateFormat.format(todo.getDate());
    }

    public String getDescription() {
        return todo.getDescription();
    }
}
