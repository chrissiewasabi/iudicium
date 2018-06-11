package xyz.megundo.busara.data;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

import xyz.megundo.busara.models.Category;

@AutoValue
public abstract class CategoriesResponse {
    public static JsonAdapter<CategoriesResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_CategoriesResponse.MoshiJsonAdapter(moshi);
    }

    @Json(name = "results")//only get the results array
    public abstract List<Category> categories();

}
