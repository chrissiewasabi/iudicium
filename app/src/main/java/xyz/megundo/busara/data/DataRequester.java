package xyz.megundo.busara.data;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import xyz.megundo.busara.models.Category;
import xyz.megundo.busara.models.Videos;

public class DataRequester {
    private final CategoryService service;

    @Inject
    DataRequester(CategoryService service) {
        this.service = service;
    }

    //jhg
    public Single<List<Category>> getCategories() {
        return service.getCategories()
                .map(CategoriesResponse::categories)
                .subscribeOn(Schedulers.io());
    }


    public Single<List<Videos>> getVideos() {
        return service.getVideoList()
                .map(VideosResponse::videos)
                .subscribeOn(Schedulers.io());
    }



}
