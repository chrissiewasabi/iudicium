package xyz.megundo.busara.data;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CategoryService {

    @Headers({
            "Authorization: Bearer Nd234JP4YrYOE9RUT7UF1a2XK6D7aT"

    })
    @GET("categories")
    Single<CategoriesResponse> getCategories();
}
