package xyz.megundo.busara.categories;

import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.megundo.busara.R;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.ScreenLifecycleTask;
import xyz.megundo.busara.util.ButterKnifeUtils;

@ScreenScope
public class CategoriesUIManager extends ScreenLifecycleTask {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Unbinder unbinder;

    @Inject
    CategoriesUIManager() {

    }

    @Override
    public void onEnterScope(View view) {
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle(R.string.title_category);
    }

    @Override
    public void onExitScope() {
        ButterKnifeUtils.unbind(unbinder);
    }
}
