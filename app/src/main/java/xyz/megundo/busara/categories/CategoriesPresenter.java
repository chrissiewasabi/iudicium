package xyz.megundo.busara.categories;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import xyz.megundo.busara.data.CategoryRequester;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.models.Category;

@ScreenScope
class CategoriesPresenter implements CategoriesAdapter.CategoryClickedListener {
    private final CategoriesViewModel viewModel;
    private final CategoryRequester categoryRequester;

    @Inject
    public CategoriesPresenter(CategoriesViewModel viewModel, CategoryRequester categoryRequester) {
        this.viewModel = viewModel;
        this.categoryRequester = categoryRequester;
        loadCategories();

    }

    @SuppressLint("CheckResult")
    private void loadCategories() {
        categoryRequester.getCategories()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.categoriesUpdated(), viewModel.onError());


    }

    @Override
    public void onRepoClicked(Category category) {

    }
}
