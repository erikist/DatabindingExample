package it.polarorb.databindingexample.mvvm.list;


import android.databinding.BaseObservable;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;

public class ListViewModel extends BaseObservable {
    private List<Todo> todos = MockData.getMockList();
    private TodoListAdapter adapter;

    public ListViewModel(TodoListAdapter adapter) {
        this.adapter = adapter;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void onResume() {
        adapter.setTodoList(todos);
    }
}
