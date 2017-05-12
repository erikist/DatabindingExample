package it.polarorb.databindingexample.mvp.list;

import android.support.v4.app.FragmentManager;
import android.view.View;

import java.util.List;

import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;
import it.polarorb.databindingexample.mvp.add.AddFragment;

public class ListPresenter {
    private final TodoListAdapter adapter;
    private List<Todo> todos = MockData.todoList;
    private FragmentManager fragmentManager;

    public ListPresenter(TodoListAdapter adapter) {
        this.adapter = adapter;
    }

    public TodoListAdapter getAdapter() {
        return adapter;
    }

    public void onResume() {
        adapter.setTodoList(todos);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onAddClicked(View view) {
        if (fragmentManager != null) {
            AddFragment addFragment = new AddFragment();

            fragmentManager.beginTransaction().replace(R.id.content_view, addFragment).addToBackStack(null).commit();
        } else {
            throw new IllegalStateException("FragmentManager is not set");
        }
    }
}
