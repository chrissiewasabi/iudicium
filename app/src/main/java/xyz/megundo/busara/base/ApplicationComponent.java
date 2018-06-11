package xyz.megundo.busara.base;

import javax.inject.Singleton;

import dagger.Component;
import xyz.megundo.busara.data.CategoryServiceModule;
import xyz.megundo.busara.networking.ServiceModule;

/* make it singleton-its lifecycle=lifecycle of app*/
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        CategoryServiceModule.class,
})
public interface ApplicationComponent {
    void inject(MyApplication myApplication);
}
