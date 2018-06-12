package xyz.megundo.busara.videos;

import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;
import xyz.megundo.busara.R;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.models.Videos;

@ScreenScope
public class VideoListViewModel {

    private final BehaviorRelay<VideosState> videosStateRelay = BehaviorRelay.create();


    @Inject
    public VideoListViewModel() {
        videosStateRelay.accept(VideosState.builder().loading(true).build());
    }

    Observable<VideosState> listings() {
        return videosStateRelay;
    }


    Consumer<List<Videos>> processVideos() {
        return listings -> videosStateRelay.accept(
                VideosState.builder()
                        .loading(false)
                        .listings(listings)
                        .build());


    }

    Consumer<Throwable> ListingError() {
        return throwable -> {
            Timber.e(throwable, "Error loading listing");
            videosStateRelay.accept(
                    VideosState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_categories)
                            .build());
        };
    }
}
