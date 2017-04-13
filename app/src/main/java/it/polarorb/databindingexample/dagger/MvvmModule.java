package it.polarorb.databindingexample.dagger;

import dagger.Module;
import dagger.Provides;
import it.polarorb.databindingexample.mvvm.list.ListViewModel;
import it.polarorb.databindingexample.mvvm.list.TodoListAdapter;

@Module
public class MvvmModule {
    @Provides
    public TodoListAdapter providesMvvmTodoListAdapter() {
        return new TodoListAdapter();
    }

    @Provides
    public ListViewModel providesListViewModel(TodoListAdapter adapter) {
        return new ListViewModel(adapter);
    }
}
