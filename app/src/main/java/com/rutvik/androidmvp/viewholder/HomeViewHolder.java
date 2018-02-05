package com.rutvik.androidmvp.viewholder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;


import com.rutvik.androidmvp.R;
import com.rutvik.androidmvp.base.BaseViewHolder;
import butterknife.BindView;

/**
 * Created by rutvik on 2/2/18.
 */

public class HomeViewHolder extends BaseViewHolder {

    @BindView(R.id.tvName)
    AppCompatTextView tvName;

    @BindView(R.id.ivAlbum)
    AppCompatImageView ivAlbum;


    public HomeViewHolder(View itemView) {
        super(itemView);
    }

    public AppCompatTextView getTvName(){ return tvName; }

    public AppCompatImageView getImageView(){ return ivAlbum; }
}
