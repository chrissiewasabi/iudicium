package xyz.megundo.busara.categories;

import com.jakewharton.rxrelay2.BehaviorRelay;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;
import xyz.megundo.busara.R;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.models.Category;

@ScreenScope
class CategoriesViewModel {

    //no terminal events  using relays
    private final BehaviorRelay<List<Category>> categoryRelay = BehaviorRelay.create();
    private final BehaviorRelay<Integer> errorRelay = BehaviorRelay.create();
    private final BehaviorRelay<Boolean> loadingRelay = BehaviorRelay.create();

    @Inject
    public CategoriesViewModel() {
    }

    Observable<Boolean> loading() {
        return loadingRelay;
    }

    Observable<List<Category>> categories() {
        return categoryRelay;
    }

    Observable<Integer> error() {
        return errorRelay;
    }


    Consumer<Boolean> loadingUpdated() {
        return loadingRelay;
    }

    Consumer<List<Category>> categoriesUpdated() {
        errorRelay.accept(-1);
        return categoryRelay;
    }

    Consumer<Throwable> onError() {
        return throwable -> {
            Timber.e(throwable, "Error");
            errorRelay.accept(R.string.api_error_categories);
        };
    }
}
