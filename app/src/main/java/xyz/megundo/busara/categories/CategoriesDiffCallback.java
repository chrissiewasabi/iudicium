package xyz.megundo.busara.categories;


import android.support.v7.util.DiffUtil;

import java.util.List;

import xyz.megundo.busara.models.Category;


public class CategoriesDiffCallback extends DiffUtil.Callback {

    private final List<Category> oldList;
    private final List<Category> newList;

    public CategoriesDiffCallback(List<Category> oldList, List<Category> newList) {
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
