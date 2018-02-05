package com.rutvik.androidmvp.ui.home;



import android.content.Context;
import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rutvik.androidmvp.R;
import com.rutvik.androidmvp.base.BaseRecyclerAdapter;
import com.rutvik.androidmvp.data.model.albumdata.AlbumResponseModel;
import com.rutvik.androidmvp.di.ApplicationContext;
import com.rutvik.androidmvp.viewholder.HomeViewHolder;

import java.util.List;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomeAdapter extends BaseRecyclerAdapter<AlbumResponseModel,HomeViewHolder> {

    private Context context;
    HomeAdapter(Context context,Class<HomeViewHolder> viewHolderClass, int modelLayout) {
        super(viewHolderClass, modelLayout);
        this.context=context;
    }

    @Override
    protected void populateViewHolder(HomeViewHolder viewHolder, AlbumResponseModel model, int position) {
        viewHolder.getTvName().setText(model.getTitle());
        loadimage(model.getThumbnailUrl(),viewHolder.getImageView());
    }

    @Override
    public void setItems(List<AlbumResponseModel> items) {
        super.setItems(items);
    }

    @Override
    public void clearItems() {
        super.clearItems();
    }

    private void loadimage(String url, AppCompatImageView imageView){
        RequestOptions requestOptions=new RequestOptions()
                .centerCrop()
                .error(R.drawable.glide_logo)
                .placeholder(R.drawable.glide_logo);
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
}
