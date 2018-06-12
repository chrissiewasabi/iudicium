package xyz.megundo.busara.di;


import dagger.android.AndroidInjector;
import xyz.megundo.busara.lifecycle.DisposableManager;

public interface ScreenComponent<T> extends AndroidInjector<T> {

    @ForScreen
    DisposableManager disposableManager();
}
