package xyz.megundo.busara.home;

import com.bluelinelabs.conductor.Controller;

import xyz.megundo.busara.R;
import xyz.megundo.busara.base.BaseActivity;
import xyz.megundo.busara.categories.CategoriesController;

public class MainActivity extends BaseActivity {



    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Controller initialScreen() {
        return new CategoriesController();
    }


}
