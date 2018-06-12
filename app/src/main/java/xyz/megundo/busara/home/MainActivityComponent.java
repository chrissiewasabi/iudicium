package xyz.megundo.busara.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import xyz.megundo.busara.di.ActivityScope;
import xyz.megundo.busara.networking.ui.ActivityViewInterceptorModule;
import xyz.megundo.busara.ui.NavigationModule;

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class,
        ActivityViewInterceptorModule.class,
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
