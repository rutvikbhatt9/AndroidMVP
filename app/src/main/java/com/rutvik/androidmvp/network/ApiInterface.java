package com.rutvik.androidmvp.network;

import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Observable<List<AlbumResponseModel>> getAlbumData();
}