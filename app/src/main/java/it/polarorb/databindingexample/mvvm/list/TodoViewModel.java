package it.polarorb.databindingexample.mvvm.list;


import android.databinding.BaseObservable;

import it.polarorb.databindingexample.common.Formatters;
import it.polarorb.databindingexample.models.Todo;

public class TodoViewModel extends BaseObservable {
    Todo todo;

    public TodoViewModel(Todo todo) {
        this.todo = todo;
    }

    public String getTitle() {
        return todo.getTitle();
    }

    public String getDate() {
        return Formatters.TODO_DATE_FORMATTER.format(todo.getDate());
    }

    public String getDescription() {
        return todo.getDescription();
    }
}
