package com.rutvik.androidmvp.ui.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.rutvik.androidmvp.AndroidMVP;
import com.rutvik.androidmvp.R;
import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;
import com.rutvik.androidmvp.di.ApplicationContext;
import com.rutvik.androidmvp.network.Service;
import com.rutvik.androidmvp.viewholder.HomeViewHolder;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    Service service;

    HomePresenter homePresenter;

    @BindView(R.id.rvBrandList)
    public RecyclerView rvBrandList;

    @BindView(R.id.pbLoader)
    public ProgressBar pbLoader;

    HomeAdapter homeAdapter;

    @Inject
    Gson gson;

    @BindView(R.id.srlHome)
    SwipeRefreshLayout srlHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        AndroidMVP.get(this).getApplicationComponent().inject(this);
        homePresenter=new HomePresenter(service,this);
        init();
        homePresenter.getCityList();

    }

    private void init() {
        srlHome.setOnRefreshListener(this);
        rvBrandList.setLayoutManager(new LinearLayoutManager(this));
        homeAdapter=new HomeAdapter(this,HomeViewHolder.class,R.layout.item_home);
        rvBrandList.setAdapter(homeAdapter);
    }


    @Override
    public void showWait() {
        pbLoader.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        pbLoader.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(this,failureMessage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBrandListDataSuccess(List<AlbumResponseModel> albumResponseModel) {
        Log.i("Response",gson.toJson(albumResponseModel));
        homeAdapter.clearItems();
        homeAdapter.setItems(albumResponseModel);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onStop();
    }

    @Override
    public void onRefresh() {
        srlHome.setRefreshing(false);
        homePresenter.getCityList();
    }
}
