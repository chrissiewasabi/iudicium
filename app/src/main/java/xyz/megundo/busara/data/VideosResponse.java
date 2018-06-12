package xyz.megundo.busara.data;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

import xyz.megundo.busara.models.Videos;

@AutoValue
public abstract class VideosResponse {
    public static JsonAdapter<VideosResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_VideosResponse.MoshiJsonAdapter(moshi);
    }

    @Json(name = "results")
    public abstract List<Videos> videos();

}
