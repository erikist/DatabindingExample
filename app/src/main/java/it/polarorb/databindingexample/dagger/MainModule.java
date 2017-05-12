package it.polarorb.databindingexample.dagger;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    Application application;

    public MainModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }
}
