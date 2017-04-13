package it.polarorb.databindingexample.mvp.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import it.polarorb.databindingexample.R;
import it.polarorb.databindingexample.models.Todo;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {
    List<Todo> todoList = new ArrayList<>();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public void setTodoList(List<Todo> todoList) {
        this.todoList.clear();
        this.todoList.addAll(todoList);
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
        // The following is illustrative of how coupling is more prone to occur in these circumstances.
        // We are formatting and altering the UI from within an adapter.
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
            // We have effectively tethered the view to the code with this implementation. Alterations to view structure necessitate
            // changes here. This can be avoided with databinding.
            titleTextView = (TextView) itemView.findViewById(R.id.title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.description);
            dateTextView = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
