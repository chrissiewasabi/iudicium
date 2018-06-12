package xyz.megundo.busara.base;


import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.Multibinds;
import xyz.megundo.busara.di.ForScreen;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.DisposableManager;
import xyz.megundo.busara.lifecycle.ScreenLifecycleTask;


@Module
public abstract class ScreenModule {

    @Provides
    @ScreenScope
    @ForScreen
    static DisposableManager provideDisposableManager() {
        return new DisposableManager();
    }

    @Multibinds
    abstract Set<ScreenLifecycleTask> screenLifecycleTasks();
}
