package xyz.megundo.busara.videos;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import java.util.List;

import xyz.megundo.busara.models.Videos;

@AutoValue
abstract class VideosState {
    static Builder builder() {
        return new AutoValue_VideosState.Builder();
    }

    abstract boolean loading();

    @Nullable
    abstract List<Videos> listings();

    @Nullable
    abstract Integer errorRes();

    boolean isSuccess() {
        return errorRes() == null;
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder listings(List<Videos> listings);

        abstract Builder errorRes(Integer errorRes);

        abstract VideosState build();
    }
}
