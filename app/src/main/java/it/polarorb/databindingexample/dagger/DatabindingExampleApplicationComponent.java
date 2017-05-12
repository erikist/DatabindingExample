package it.polarorb.databindingexample.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class, MvvmModule.class, MvpModule.class})
public interface DatabindingExampleApplicationComponent {
    void inject(it.polarorb.databindingexample.mvp.list.ListFragment listFragment);
    void inject(it.polarorb.databindingexample.mvvm.list.ListFragment listFragment);
    void inject(it.polarorb.databindingexample.mvvm.add.AddFragment addFragment);
    void inject(it.polarorb.databindingexample.mvp.add.AddFragment addFragment);
}
