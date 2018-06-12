package xyz.megundo.busara.categories;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import xyz.megundo.busara.base.ScreenModule;
import xyz.megundo.busara.di.ScreenComponent;
import xyz.megundo.busara.di.ScreenScope;

@ScreenScope
@Subcomponent(modules = {
        ScreenModule.class,
        CategoriesScreenModule.class,
})
public interface CategoriesComponent extends ScreenComponent<CategoriesController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CategoriesController> {

    }

}
