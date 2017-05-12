package it.polarorb.databindingexample.dagger;

import dagger.Module;
import dagger.Provides;
import it.polarorb.databindingexample.mvvm.list.ListViewModel;
import it.polarorb.databindingexample.mvvm.list.TodoListAdapter;
import it.polarorb.databindingexample.mvvm.add.AddViewModel;

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

    @Provides
    public AddViewModel providesAddViewModel() {
        return new AddViewModel();
    }
}
