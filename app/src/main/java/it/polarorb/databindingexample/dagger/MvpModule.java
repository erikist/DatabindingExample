package it.polarorb.databindingexample.dagger;

import dagger.Module;
import dagger.Provides;
import it.polarorb.databindingexample.mvp.add.AddPresenter;
import it.polarorb.databindingexample.mvp.list.ListPresenter;
import it.polarorb.databindingexample.mvp.list.TodoListAdapter;
import it.polarorb.databindingexample.mvvm.add.AddViewModel;

@Module
public class MvpModule {
    @Provides
    public TodoListAdapter providesMvpTodoListAdapter() {
        return new TodoListAdapter();
    }

    @Provides
    public ListPresenter providesListPresenter(TodoListAdapter adapter) {
        return new ListPresenter(adapter);
    }

    @Provides
    public AddPresenter providesAddPresenter() {
        return new AddPresenter();
    }
}
