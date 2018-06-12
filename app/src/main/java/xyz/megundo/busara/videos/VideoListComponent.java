package xyz.megundo.busara.videos;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import xyz.megundo.busara.base.ScreenModule;
import xyz.megundo.busara.di.ScreenScope;

@ScreenScope
@Subcomponent(modules = {
        ScreenModule.class,
        VideoScreenModule.class,
})
public interface VideoListComponent extends AndroidInjector<VideoListController> {

    @Subcomponent.Builder

    abstract class Builder extends AndroidInjector.Builder<VideoListController> {
        @BindsInstance
        public abstract void bindCatName(@Named("category_name") String categoryName);

        @BindsInstance
        public abstract void bindCatNumber(@Named("category_number") String categoryNumber);

        @Override
        public void seedInstance(VideoListController instance) {
            bindCatName(instance.getArgs().getString(VideoListController.CATEGORY_NAME));
            bindCatNumber(instance.getArgs().getString(VideoListController.CATEGORY_NUMBER));
        }
    }

}
