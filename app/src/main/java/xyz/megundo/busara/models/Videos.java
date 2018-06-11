package xyz.megundo.busara.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class Videos {

    public static JsonAdapter<Videos> jsonAdapter(Moshi moshi) {
        return new AutoValue_Videos.MoshiJsonAdapter(moshi);
    }

    @Json(name = "id")
    public abstract int id();

    @Json(name = "name")
    public abstract String name();

    @Json(name = "description")
    public abstract String description();

    @Json(name = "file_path")
    public abstract String file_path();

    @Json(name = "created")
    public abstract String dateCreated();
}
