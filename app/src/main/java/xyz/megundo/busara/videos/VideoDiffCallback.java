package xyz.megundo.busara.videos;


import android.support.v7.util.DiffUtil;

import java.util.List;

import xyz.megundo.busara.models.Videos;


public class VideoDiffCallback extends DiffUtil.Callback {

    private final List<Videos> oldList;
    private final List<Videos> newList;

    VideoDiffCallback(List<Videos> oldList, List<Videos> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).id() == newList.get(newItemPosition).id();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
