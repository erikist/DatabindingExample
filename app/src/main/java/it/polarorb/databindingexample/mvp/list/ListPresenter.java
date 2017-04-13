package it.polarorb.databindingexample.mvp.list;


import java.util.List;

import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;

public class ListPresenter {
    private final TodoListAdapter adapter;
    private List<Todo> todos = MockData.getMockList();

    public ListPresenter(TodoListAdapter adapter) {
        this.adapter = adapter;
    }

    public TodoListAdapter getAdapter() {
        return adapter;
    }

    public void onResume() {
        adapter.setTodoList(todos);
    }
}
