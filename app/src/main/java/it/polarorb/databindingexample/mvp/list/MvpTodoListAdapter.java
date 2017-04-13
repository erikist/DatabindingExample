package it.polarorb.databindingexample.mvp.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.models.Todo;

public class MvpTodoListAdapter extends RecyclerView.Adapter<MvpTodoListAdapter.TodoViewHolder> {
    List<Todo> todoList;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
        this.notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_todo, parent, false);
        TodoViewHolder todoViewHolder = new TodoViewHolder(itemView);
        return todoViewHolder;
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todoList.get(position);
        holder.titleTextView.setText(todo.getTitle());
        holder.dateTextView.setText(simpleDateFormat.format(todo.getDate()));
        holder.descriptionTextView.setText(todo.getDescription());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final TextView dateTextView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.description);
            dateTextView = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
