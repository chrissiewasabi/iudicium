package xyz.megundo.busara.categories;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import xyz.megundo.busara.di.ScreenScope;

@ScreenScope
@Subcomponent
public interface CategoriesComponent extends AndroidInjector<CategoriesController> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CategoriesController> {

    }

}
