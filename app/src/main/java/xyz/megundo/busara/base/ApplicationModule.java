package xyz.megundo.busara.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/* is a  provider of dependencies*/
@Module
public class ApplicationModule {

    private final Application application;

    ApplicationModule(Application application) {
        this.application = application;
    }

    /* Any class can inject the application context*/
    @Provides
    Context provideApplicationContext() {
        return application;
    }
}
