package xyz.megundo.busara.videos;


import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import xyz.megundo.busara.lifecycle.ScreenLifecycleTask;

@Module
public abstract class VideoScreenModule {

    @Binds
    @IntoSet
    abstract ScreenLifecycleTask bindUiManagerTask(VideosUIManager uiManager);


}
