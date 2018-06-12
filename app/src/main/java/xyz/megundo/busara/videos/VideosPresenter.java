package xyz.megundo.busara.videos;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;
import xyz.megundo.busara.data.CategoryRepository;
import xyz.megundo.busara.di.ForScreen;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.DisposableManager;
import xyz.megundo.busara.models.Videos;

@ScreenScope
public class VideosPresenter implements VideoListAdapter.VideoClickedListener {
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

    @Override
    public void onVideoClicked(Videos video) {
//       Todo  improve player
        String url = video.file_path(); // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

