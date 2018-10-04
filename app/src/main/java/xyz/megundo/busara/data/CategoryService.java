package xyz.megundo.busara.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CategoryService {

    @Headers({
            "Authorization: Bearer F3w65Zsn26OFi0LrYSVP4ukynh1BuF"

    })
    @GET("categories")
    Single<CategoriesResponse> getCategories();

    @Headers({
            "Authorization: Bearer F3w65Zsn26OFi0LrYSVP4ukynh1BuF"

    })
    @GET("videos")
    Single<VideosResponse> getVideoList();
}
