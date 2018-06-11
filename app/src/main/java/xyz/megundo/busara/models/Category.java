package xyz.megundo.busara.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Category {


    public static JsonAdapter<Category> jsonAdapter(Moshi moshi) {
        return new AutoValue_Category.MoshiJsonAdapter(moshi);
    }

    @Json(name = "id")
    public abstract int id();

    @Json(name = "name")
    public abstract String name();

    @Json(name = "description")
    public abstract String description();

    @Json(name = "is_active")
    public abstract boolean is_active();

    @Json(name = "created")
    public abstract String dateCreated();

}
