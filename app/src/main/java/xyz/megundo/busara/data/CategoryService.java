package xyz.megundo.busara.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CategoryService {

    @Headers({
            "Authorization: Bearer Fev8A8XIy7KyoahLjrEi6L46bTjlKZ"

    })
    @GET("categories")
    Single<CategoriesResponse> getCategories();

    @Headers({
            "Authorization: Bearer Fev8A8XIy7KyoahLjrEi6L46bTjlKZ"

    })
    @GET("videos")
    Single<VideosResponse> getVideoList();
}
