package xyz.megundo.busara.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import xyz.megundo.busara.categories.CategoriesComponent;
import xyz.megundo.busara.categories.CategoriesController;
import xyz.megundo.busara.di.ControllerKey;

@Module(subcomponents = {
        CategoriesComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(CategoriesController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindCategoriesInjector(CategoriesComponent.Builder builder);
}
