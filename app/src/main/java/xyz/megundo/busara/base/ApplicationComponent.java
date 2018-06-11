package xyz.megundo.busara.base;

import javax.inject.Singleton;

import dagger.Component;

/* make it singleton-its lifecycle=lifecycle of app*/
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
