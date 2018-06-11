package xyz.megundo.busara.base;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import xyz.megundo.busara.home.MainActivity;
import xyz.megundo.busara.home.MainActivityComponent;

@Module(subcomponents = {
        MainActivityComponent.class,
})

public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);

}
