package xyz.megundo.busara.videos;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.megundo.busara.R;
import xyz.megundo.busara.models.Videos;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ContributorViewHolder> {

    private final List<Videos> data = new ArrayList<>();
    private final VideoClickedListener listener;

    public VideoListAdapter(VideoClickedListener listener) {
        this.listener = listener;
        setHasStableIds(true);
    }


    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_listing_item, parent, false);
        return new ContributorViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(ContributorViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return (data.get(position).id());
    }

    void setData(List<Videos> contributors) {
        if (contributors != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new VideoDiffCallback(data, contributors));
            data.clear();
            data.addAll(contributors);
            diffResult.dispatchUpdatesTo(this);
        } else {
            data.clear();
            notifyDataSetChanged();
        }
    }

    interface VideoClickedListener {

        void onVideoClicked(Videos video);
    }
    static final class ContributorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_video_name)
        TextView listingnameText;

        @BindView(R.id.tv_video_description)
        TextView listingIDText;

        @BindView(R.id.iv_avatar)
        ImageView avatarImageView;

        private Videos listing;

        ContributorViewHolder(View itemView, VideoClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (listing != null) {
                    listener.onVideoClicked(listing);
                }
            });
        }

        void bind(Videos listing) {
            this.listing = listing;
            listingnameText.setText(listing.name());
            listingIDText.setText(listing.description());
            //Todo show thumbnail with glide

        }
    }
}
