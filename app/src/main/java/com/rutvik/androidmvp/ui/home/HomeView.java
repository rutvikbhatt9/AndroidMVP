package com.rutvik.androidmvp.ui.home;


import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;

import java.util.List;

/**
 * Created by rutvik on 2/2/18.
 */

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String failureMessage);

    void onBrandListDataSuccess(List<AlbumResponseModel> albumResponseModel);

}
