package it.polarorb.databindingexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import it.polarorb.databindingexample.mvvm.list.ListFragment;

@Singleton
@Component(modules = {MainModule.class, MvvmModule.class, MvpModule.class})
public interface DatabindingExampleApplicationComponent {
    void inject(it.polarorb.databindingexample.mvp.list.ListFragment listFragment);
    void inject(ListFragment listFragment);
}
