package it.polarorb.databindingexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import it.polarorb.databindingexample.mvp.list.MvpListFragment;
import it.polarorb.databindingexample.mvvm.list.MvvmListFragment;

@Singleton
@Component(modules = {MainModule.class, ViewModelModule.class, PresenterModule.class})
public interface DatabindingExampleApplicationComponent {
    void inject(MvpListFragment mvpListFragment);
    void inject(MvvmListFragment mvvmListFragment);
}
