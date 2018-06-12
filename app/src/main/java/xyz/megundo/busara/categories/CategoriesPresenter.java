package xyz.megundo.busara.categories;

import android.annotation.SuppressLint;
import android.util.Log;

import javax.inject.Inject;

import xyz.megundo.busara.data.CategoryRepository;
import xyz.megundo.busara.di.ForScreen;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.DisposableManager;
import xyz.megundo.busara.models.Category;
import xyz.megundo.busara.ui.ScreenNavigator;

@ScreenScope
class CategoriesPresenter implements CategoriesAdapter.CategoryClickedListener {
    private final CategoriesViewModel viewModel;
    private final CategoryRepository categoryRepository;
    private final ScreenNavigator screenNavigator;
    private final DisposableManager disposableManager;

    @Inject
    public CategoriesPresenter(CategoriesViewModel viewModel, CategoryRepository categoryRepository,
                               ScreenNavigator screenNavigator,
                               @ForScreen DisposableManager disposableManager) {
        this.viewModel = viewModel;
        this.categoryRepository = categoryRepository;
        this.screenNavigator = screenNavigator;
        this.disposableManager = disposableManager;
        loadCategories();

    }

    @SuppressLint("CheckResult")
    private void loadCategories() {
        categoryRepository.getCategories()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.categoriesUpdated(), viewModel.onError());


    }

    @Override
    public void onRepoClicked(Category category) {
        Log.d("d", "onRepoClicked: " + category.id());
        screenNavigator.goToVideos(category.name(), Integer.toString(category.id()));

    }
}
