package xyz.megundo.busara.ui;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import xyz.megundo.busara.lifecycle.ActivityLifecycleTask;

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);

    @Binds
    @IntoSet
    abstract ActivityLifecycleTask bindScreenNavigatorTask(DefaultScreenNavigator screenNavigator);
}
