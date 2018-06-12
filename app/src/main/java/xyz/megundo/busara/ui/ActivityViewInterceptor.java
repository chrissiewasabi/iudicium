package xyz.megundo.busara.ui;

import android.app.Activity;
import android.support.annotation.LayoutRes;

public interface ActivityViewInterceptor {

    ActivityViewInterceptor DEFAULT = new ActivityViewInterceptor() {
        @Override
        public void setContentView(Activity activity, int layoutRes) {
            activity.setContentView(layoutRes);
        }

        @Override
        public void clear() {

        }
    };

    void setContentView(Activity activity, @LayoutRes int layoutRes);

    void clear();
}
