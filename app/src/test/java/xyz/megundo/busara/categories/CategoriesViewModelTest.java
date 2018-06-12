package xyz.megundo.busara.categories;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.observers.TestObserver;
import xyz.megundo.busara.R;
import xyz.megundo.busara.data.CategoriesResponse;
import xyz.megundo.busara.testutils.TestUtils;

public class CategoriesViewModelTest {

    private CategoriesViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new CategoriesViewModel();
    }

    @Test
    public void loading() throws Exception {

        TestObserver<Boolean> loadingObserver = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);
        loadingObserver.assertValues(true, false);
    }

    @Test
    public void categories() throws Exception {

        CategoriesResponse response = TestUtils.loadJson("mock/getMockCategories.json", CategoriesResponse.class);
        viewModel.categoriesUpdated().accept(response.categories());
        viewModel.categories().test().assertValue(response.categories());
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.categoriesUpdated().accept(Collections.emptyList());
        errorObserver.assertValues
                (R.string.api_error_categories, -1);
    }
}