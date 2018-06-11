package xyz.megundo.busara.categories;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import xyz.megundo.busara.R;
import xyz.megundo.busara.base.BaseController;

public class CategoriesController extends BaseController {
    @Inject
    CategoriesPresenter presenter;
    @Inject
    CategoriesViewModel viewModel;

    @BindView(R.id.cat_list)
    RecyclerView catList;
    @BindView(R.id.loading_indicator)
    View loadingView;
    @BindView(R.id.tv_error)
    TextView errorText;

    @Override
    protected void onViewBound(View view) {
        catList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        catList.setAdapter(new CategoriesAdapter(presenter));
    }

    @Override
    protected Disposable[] subscriptions() {
        return new Disposable[]{
                viewModel.loading()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(loading -> {
                    loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
                    catList.setVisibility(loading ? View.GONE : View.VISIBLE);
                    errorText.setVisibility(loading ? View.GONE : errorText.getVisibility());

                }),
                viewModel.categories()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(((CategoriesAdapter) catList.getAdapter())::setData),
                viewModel.error()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(errorRes -> {
                    if (errorRes == -1) {
                        errorText.setText(null);
                        errorText.setVisibility(View.GONE);
                    } else {
                        errorText.setVisibility(View.VISIBLE);
                        catList.setVisibility(View.GONE);
                        errorText.setText(errorRes);
                    }
                }),


        };
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_categories;
    }

}
