package xyz.megundo.busara.categories;


import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import xyz.megundo.busara.lifecycle.ScreenLifecycleTask;

@Module
public abstract class CategoriesScreenModule {

    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUiManager(CategoriesUIManager uiManager);
}
