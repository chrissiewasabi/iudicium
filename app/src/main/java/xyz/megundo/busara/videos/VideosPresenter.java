package xyz.megundo.busara.videos;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;
import xyz.megundo.busara.data.CategoryRepository;
import xyz.megundo.busara.di.ForScreen;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.DisposableManager;

@ScreenScope
public class VideosPresenter {
    @Inject
    public VideosPresenter(
            @Named("category_name") String categoryName,
            @Named("category_number") String categoryNumber,
            CategoryRepository dataRepository,
            VideoListViewModel viewModel,
            @ForScreen DisposableManager disposableManager) {


        disposableManager.add(dataRepository.getVideos(categoryNumber)


                .doOnError(viewModel.ListingError())
                .subscribe(viewModel.processVideos(), throwable -> {
                    //Todo handle error
                    Timber.e(throwable, "Error loading repos" + throwable.getMessage());
                }));

    }
}

