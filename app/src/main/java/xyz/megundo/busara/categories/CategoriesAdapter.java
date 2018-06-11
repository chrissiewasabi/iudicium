package xyz.megundo.busara.categories;


import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.megundo.busara.R;
import xyz.megundo.busara.models.Category;


class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private final CategoryClickedListener listener;
    private final List<Category> data = new ArrayList<>();

    CategoriesAdapter(CategoryClickedListener listener) {
        this.listener = listener;
        setHasStableIds(true);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_list_item, parent, false);
        return new CategoryViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    void setData(List<Category> subCategories) {
        if (subCategories != null) {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new CategoriesDiffCallback(data, subCategories));
            data.clear();
            data.addAll(subCategories);
            diffResult.dispatchUpdatesTo(this);
        } else {
            data.clear();
            notifyDataSetChanged();
        }
    }

    interface CategoryClickedListener {

        void onRepoClicked(Category category);
    }

    static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_cat_name)
        TextView categoryNameText;
        @BindView(R.id.tv_repo_description)
        TextView repoDescriptionText;


        private Category category;

        CategoryViewHolder(View itemView, CategoryClickedListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (category != null) {
                    listener.onRepoClicked(category);
                }
            });
        }

        void bind(Category category) {
            this.category = category;
            categoryNameText.setText(category.name());
            repoDescriptionText.setText(category.description());

        }
    }
}
