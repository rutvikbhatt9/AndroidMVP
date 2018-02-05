package com.rutvik.androidmvp.ui.home;


import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;
import com.rutvik.androidmvp.network.Service;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomePresenter {

    private Service service;
    private HomeView homeView;
    CompositeDisposable compositeDisposable;

    public HomePresenter(Service service, HomeView homeView) {

        this.service = service;
        this.homeView = homeView;
        compositeDisposable = new CompositeDisposable();
    }

    void getCityList() {
        homeView.showWait();
        Disposable disposable = service.getAlbumdata(new Service.BrandListCallback() {
            @Override
            public void onSuccess(List<AlbumResponseModel> albumResponseModel) {
                homeView.removeWait();
                homeView.onBrandListDataSuccess(albumResponseModel);
            }

            @Override
            public void onError(Throwable throwable) {
                homeView.removeWait();
                homeView.onFailure(throwable.getLocalizedMessage());
            }
        });

        compositeDisposable.add(disposable);

    }

    public void onStop() {
        compositeDisposable.dispose();
    }
}
