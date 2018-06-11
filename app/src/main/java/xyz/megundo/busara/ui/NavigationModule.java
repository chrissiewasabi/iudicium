package xyz.megundo.busara.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigator provideScreenNavigator(DefaultScreenNavigator screenNavigator);
}
