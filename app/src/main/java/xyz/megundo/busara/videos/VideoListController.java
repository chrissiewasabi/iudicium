package xyz.megundo.busara.videos;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import xyz.megundo.busara.R;
import xyz.megundo.busara.base.BaseController;

public class VideoListController extends BaseController {
    static final String CATEGORY_NAME = "category_name";
    static final String CATEGORY_NUMBER = "category_number";
    @Inject
    VideoListViewModel viewModel;
    @Inject
    VideosPresenter presenter;
    @BindView(R.id.listing_list)
    RecyclerView videosList;

    @BindView(R.id.listing_loading_indicator)
    View videosLoadingView;

    @BindView(R.id.tv_listing_error)
    TextView errorText;

    public VideoListController(Bundle bundle) {
        super(bundle);
    }

    public static Controller newInstance(String categoryNumber, String categoryName) {
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_NAME, categoryName);
        bundle.putString(CATEGORY_NUMBER, categoryNumber);

        return new VideoListController(bundle);

    }

    @Override
    protected void onViewBound(View view) {
        videosList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        videosList.setAdapter(new VideoListAdapter());
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[]{
                viewModel.listings()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(listingDetails -> {
                    if (listingDetails.loading()) {
                        videosLoadingView.setVisibility(View.VISIBLE);
                        videosList.setVisibility(View.GONE);
                        errorText.setVisibility(View.GONE);
                        errorText.setText(null);
                    } else {
                        videosLoadingView.setVisibility(View.GONE);
                        videosList.setVisibility(listingDetails.isSuccess() ? View.VISIBLE : View.GONE);
                        errorText.setVisibility(listingDetails.isSuccess() ? View.GONE : View.VISIBLE);
                        if (listingDetails.isSuccess()) {
                            errorText.setText(null);
                            ((VideoListAdapter) videosList.getAdapter()).setData(listingDetails.listings());
                        } else {
                            //noinspection ConstantConditions
                            errorText.setText(listingDetails.errorRes());
                        }
                    }
                })
        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_video_list;
    }
}
