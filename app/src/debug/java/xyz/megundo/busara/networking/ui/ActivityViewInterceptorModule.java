package xyz.megundo.busara.networking.ui;

import dagger.Binds;
import dagger.Module;
import xyz.megundo.busara.ui.ActivityViewInterceptor;

@Module
public abstract class ActivityViewInterceptorModule {

    @Binds
    abstract ActivityViewInterceptor bindDebugActivityViewInterceptor(DebugActivityViewInterceptor activityViewInterceptor);
}
