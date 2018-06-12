package xyz.megundo.busara.videos;


import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import xyz.megundo.busara.R;
import xyz.megundo.busara.di.ScreenScope;
import xyz.megundo.busara.lifecycle.ScreenLifecycleTask;
import xyz.megundo.busara.ui.ScreenNavigator;
import xyz.megundo.busara.util.ButterKnifeUtils;

@ScreenScope
public class VideosUIManager extends ScreenLifecycleTask {
    private final String categoryName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private Unbinder unbinder;
    private ScreenNavigator screenNavigator;

    @Inject
    public VideosUIManager(@Named("category_name") String categoryName, ScreenNavigator screenNavigator) {
        this.categoryName = categoryName;
        this.screenNavigator = screenNavigator;
    }

    @Override
    public void onEnterScope(View view) {
        unbinder = ButterKnife.bind(this, view);
        toolbar.setTitle(categoryName + " Videos");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> screenNavigator.pop());
    }

    @Override
    public void onExitScope() {
        toolbar.setNavigationOnClickListener(null);
        ButterKnifeUtils.unbind(unbinder);
    }

}
