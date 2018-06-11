package xyz.megundo.busara.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class CategoryServiceModule {
    @Provides
    @Singleton
    static CategoryService provideCategoryService(Retrofit retrofit) {
        return retrofit.create(CategoryService.class);
    }

}
