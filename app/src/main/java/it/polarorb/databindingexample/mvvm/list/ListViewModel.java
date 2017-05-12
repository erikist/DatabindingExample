package it.polarorb.databindingexample.mvvm.list;


import android.databinding.BaseObservable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.common.MockData;
import it.polarorb.databindingexample.models.Todo;
import it.polarorb.databindingexample.mvvm.add.AddFragment;

public class ListViewModel extends BaseObservable {
    private List<Todo> todos = MockData.todoList;
    private TodoListAdapter adapter;
    private FragmentManager fragmentManager;

    public ListViewModel(TodoListAdapter adapter) {
        this.adapter = adapter;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void onResume() {
        adapter.setTodoList(todos);
        adapter.notifyDataSetChanged();
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
