package com.rutvik.androidmvp.network;


import android.app.Application;
import android.content.Context;

import com.rutvik.androidmvp.AndroidMVP;
import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


/**
 * Created by Rutvik Bhatt on 2/2/18.
 */

public class Service {
    private final ApiInterface networkService;

    @Inject
    Retrofit retrofit;

    @Inject
    Application application;



    public Service(ApiInterface networkService,Context context) {
        this.networkService = networkService;
        AndroidMVP.get(context).getApplicationComponent().inject(this);
    }
    public Disposable getAlbumdata(final BrandListCallback callback){

        return retrofit.create(ApiInterface.class).getAlbumData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<AlbumResponseModel>>>() {
                    @Override
                    public ObservableSource<? extends List<AlbumResponseModel>> apply(Throwable throwable) throws Exception {
                        callback.onError(throwable);
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<List<AlbumResponseModel>>() {

                    @Override
                    public void accept(List<AlbumResponseModel> albumResponseModel) throws Exception {
                        callback.onSuccess(albumResponseModel);
                    }
                });
    }

    public interface BrandListCallback{
        void onSuccess(List<AlbumResponseModel> albumResponseModel);
        void onError(Throwable throwable);
    }

  /*  public CompositeDisposable getRandomUserData(final ServiceCallback callback) {
       // Observable<ResponseBody> observable = null;
       *//* return retrofit.create(ApiInterface.class).getRandomUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends ResponseBody>>() {
                    @Override
                    public ObservableSource<? extends ResponseBody> apply(Throwable throwable) throws Exception {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        callback.onSuccess(responseBody);
                    }
                });*//*
        return null;

    }*/

  /*  public interface ServiceCallback {
        void onSuccess(ResponseBody cityListResponse);

        void onError(NetworkError networkError);
    }*/
}
