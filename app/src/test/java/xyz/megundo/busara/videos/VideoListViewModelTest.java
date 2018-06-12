package xyz.megundo.busara.videos;

import org.junit.Before;
import org.junit.Test;

import xyz.megundo.busara.data.VideosResponse;
import xyz.megundo.busara.testutils.TestUtils;

public class VideoListViewModelTest {


    private VideoListViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new VideoListViewModel();
    }

    @Test
    public void listings() throws Exception {
        VideosResponse response = TestUtils.loadJson("mock/getMockVideos.json", VideosResponse.class);
        viewModel.processVideos().accept(response.videos());

    }

    @Test
    public void listingError() {
    }
}