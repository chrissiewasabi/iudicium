package xyz.megundo.busara.home;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import xyz.megundo.busara.categories.CategoriesComponent;
import xyz.megundo.busara.categories.CategoriesController;
import xyz.megundo.busara.di.ControllerKey;
import xyz.megundo.busara.videos.VideoListComponent;
import xyz.megundo.busara.videos.VideoListController;

@Module(subcomponents = {
        CategoriesComponent.class,
        VideoListComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(CategoriesController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindCategoriesInjector(CategoriesComponent.Builder builder);

    @Binds
    @IntoMap
    @ControllerKey(VideoListController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindVideosInjector(VideoListComponent.Builder builder);

    //Todo 1for next page
}
