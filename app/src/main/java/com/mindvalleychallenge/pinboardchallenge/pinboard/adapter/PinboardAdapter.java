package com.mindvalleychallenge.pinboardchallenge.pinboard.adapter;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mindvalley.universaldownloader.lib.interfaces.ImageLoadCallback;
import com.mindvalleychallenge.pinboardchallenge.PinboardApplication;
import com.mindvalleychallenge.pinboardchallenge.R;
import com.mindvalleychallenge.pinboardchallenge.pinboard.model.PinImage;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.AppConstants;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

import static com.mindvalleychallenge.pinboardchallenge.PinboardApplication.context;

/**
 * Created by MuhammadMahmoor on 8/16/17.
 */

public class PinboardAdapter extends RealmRecyclerViewAdapter<PinImage, PinboardAdapter.MyViewHolder> {


    public PinboardAdapter(@Nullable OrderedRealmCollection<PinImage> data, boolean autoUpdate) {
        super(data, autoUpdate, true);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pinboard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        PinImage pinImage = getItem(position);

        PinboardApplication.getUniversalDownloader().loadImage(pinImage.getSmallImage()).into(holder.pinImageView);

        // You can set placeholder image as well on universal downloader lib
//        PinboardApplication.getUniversalDownloader().loadImage(pinImage.getSmallImage()).placeHolder(R.mipmap.ic_launcher).into(holder.pinImageView);


        // We can also register callback to get bitmap
        /*PinboardApplication.getUniversalDownloader().loadImage(pinImage.getSmallImage(), new ImageLoadCallback() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                Log.i(AppConstants.TAG, "onSuccess = "+bitmap);
                holder.pinImageView.setImageBitmap(bitmap);
            }

            @Override
            public void onError(Exception ex) {
                ex.getMessage();
            }
        }).into(holder.pinImageView);*/

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        protected ImageView pinImageView;
        MyViewHolder(View view) {
            super(view);
            pinImageView = view.findViewById(R.id.pin_image);
        }
    }
}
