package xyz.megundo.busara.home;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import xyz.megundo.busara.di.ActivityScope;

@ActivityScope
@Subcomponent
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
