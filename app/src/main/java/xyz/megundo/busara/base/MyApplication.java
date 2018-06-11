package xyz.megundo.busara.base;

import android.app.Application;

import javax.inject.Inject;

import timber.log.Timber;
import xyz.megundo.busara.BuildConfig;
import xyz.megundo.busara.di.ActivityInjector;

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}
