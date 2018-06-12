package xyz.megundo.busara.videos;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static android.support.constraint.Constraints.TAG;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ContributorViewHolder> {

    private final List<Videos> data = new ArrayList<>();

    VideoListAdapter() {
        setHasStableIds(true);
    }

    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_listing_item, parent, false);
        return new ContributorViewHolder(itemView);
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

    static final class ContributorViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_video_name)
        TextView listingnameText;

        @BindView(R.id.tv_video_description)
        TextView listingIDText;

        @BindView(R.id.iv_avatar)
        ImageView avatarImageView;

        ContributorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Videos listing) {
            listingnameText.setText(listing.name());
            listingIDText.setText(listing.description());
           /* Glide.with(avatarImageView.getContext())
                    .load(listing.pictureHref())
                    .into(avatarImageView);*/
            Log.d(TAG, "bind: " + listing.file_path());

        /*    Glide
                    .with(avatarImageView.getContext())
                    .asBitmap()
                    .load(Uri.fromFile(new File(listing.file_path())))
                    .into(avatarImageView);*/
        }
    }
}
