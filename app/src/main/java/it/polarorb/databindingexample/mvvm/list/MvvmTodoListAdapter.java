package it.polarorb.databindingexample.mvvm.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.List;

import it.polarorb.databindingexample.databinding.ItemTaskBinding;
import it.polarorb.databindingexample.models.Todo;

public class MvvmTodoListAdapter extends RecyclerView.Adapter<MvvmTodoListAdapter.TodoViewHolder> {

    List<Todo> todoList;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
        this.notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemTaskBinding binding = ItemTaskBinding.inflate(inflater, parent, false);
        TodoViewHolder todoViewHolder = new TodoViewHolder(binding);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.bind(todo);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private final ItemTaskBinding binding;

        public TodoViewHolder(ItemTaskBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Todo todo) {
            binding.setViewModel(new TodoViewModel(todo));
        }
    }
}
