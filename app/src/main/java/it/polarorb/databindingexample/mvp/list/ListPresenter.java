package it.polarorb.databindingexample.mvp.list;


import java.util.List;

import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;

public class ListPresenter {

    private final MvpTodoListAdapter listAdapter;
    private List<Todo> todos = MockData.getMockList();

    public ListPresenter(MvpTodoListAdapter listAdapter) {
        this.listAdapter = listAdapter;
    }

    public MvpTodoListAdapter getListAdapter() {
        return listAdapter;
    }
}
