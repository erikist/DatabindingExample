package it.polarorb.databindingexample.dagger;


import android.app.Application;

public class DatabindingExampleApplication extends Application {
    private DatabindingExampleApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createDatabindingExampleApplicationComponent();
    }

    protected DatabindingExampleApplicationComponent createDatabindingExampleApplicationComponent() {
        return DaggerDatabindingExampleApplicationComponent
                .builder()
                .mainModule(new MainModule(this))
                .mvvmModule(new MvvmModule())
                .mvpModule(new MvpModule())
                .build();
    }

    public DatabindingExampleApplicationComponent getDatabindingExampleApplicationComponent() {
        return component;
    }
}
