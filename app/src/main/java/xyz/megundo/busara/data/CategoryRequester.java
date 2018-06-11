package xyz.megundo.busara.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import xyz.megundo.busara.models.Category;

public class CategoryRequester {
    private final CategoryService service;

    @Inject
    CategoryRequester(CategoryService service) {
        this.service = service;
    }

    public Single<List<Category>> getCategories() {
        return service.getCategories()
                .map(CategoriesResponse::categories)
                .subscribeOn(Schedulers.io());
    }

}
