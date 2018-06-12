package xyz.megundo.busara.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import xyz.megundo.busara.models.Category;
import xyz.megundo.busara.models.Videos;

@Singleton
public class CategoryRepository {
    private final Provider<DataRequester> categoryRequesterProvider;
    private final List<Category> cachedCategoryList = new ArrayList<>();
    private final Map<String, List<Videos>> cachedVideos = new HashMap<>();


    @Inject
    public CategoryRepository(Provider<DataRequester> categoryRequesterProvider) {

        this.categoryRequesterProvider = categoryRequesterProvider;

    }

    public Single<List<Category>> getCategories() {

        return Maybe.concat(cachedCategories(), apiCategories())
                .firstOrError()
                .subscribeOn(Schedulers.io());


    }

    public Single<List<Videos>> getVideos(String number) {
        return Maybe.concat(cachedVideos(number), apiVideos(number))
                .firstOrError()
                .subscribeOn(Schedulers.io());
    }


    private Maybe<List<Videos>> cachedVideos(String id) {
        return Maybe.create(e -> {
            if (cachedVideos.containsKey(id)) {
                e.onSuccess(cachedVideos.get(id));
            }
            e.onComplete();
        });
    }

    private Maybe<List<Videos>> apiVideos(String number) {
        return categoryRequesterProvider.get().getVideos()
                .doOnSuccess(videos -> cachedVideos.put(number, videos))
                .toMaybe();
    }


    private Maybe<List<Category>> cachedCategories() {
        return Maybe.create(e -> {
            if (!cachedCategoryList.isEmpty()) {
                e.onSuccess(cachedCategoryList);
            }
            e.onComplete();
        });
    }

    private Maybe<List<Category>> apiCategories() {
        return categoryRequesterProvider.get().getCategories()
                .doOnSuccess(categories -> {
                    cachedCategoryList.clear();
                    cachedCategoryList.addAll(categories);
                })
                .toMaybe();
    }
}
