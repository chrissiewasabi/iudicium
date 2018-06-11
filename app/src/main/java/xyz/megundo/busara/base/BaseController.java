package xyz.megundo.busara.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import xyz.megundo.busara.di.Injector;

public abstract class BaseController extends Controller {

    private boolean injected = false;
    private Unbinder unbinder;
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onContextAvailable(@NonNull Context context) {
//controllers are maintained through config changes
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }

    @NonNull
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        onViewBound(view);
        disposables.addAll(subscriptions());
        return view;
    }

    protected void onViewBound(View view) {

    }

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onDestroyView(@NonNull View view) {
        disposables.clear();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
