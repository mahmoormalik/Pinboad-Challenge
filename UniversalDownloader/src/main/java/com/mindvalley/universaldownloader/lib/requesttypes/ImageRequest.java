package com.mindvalley.universaldownloader.lib.requesttypes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.mindvalley.universaldownloader.lib.DownloadManager;
import com.mindvalley.universaldownloader.lib.interfaces.ImageLoadCallback;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public class ImageRequest extends DownloadManager {


    int placeHolderID;
    Drawable placeHolderDrawable;
    ImageView imageView;

    public ImageRequest(Context context, String imageURL, ImageLoadCallback imageLoadCallback) {
        super(context, imageURL, imageLoadCallback);
    }

    public ImageRequest placeHolder(int placeHolderID) {
        this.placeHolderID = placeHolderID;
        return this;
    }

    public ImageRequest placeHolder(Drawable placeHolderDrawable) {
        this.placeHolderDrawable = placeHolderDrawable;
        return this;
    }

    public void into(ImageView imageView) {
        this.imageView = imageView;
        if (placeHolderID != -1)
            this.imageView.setImageResource(placeHolderID);
        else if (placeHolderDrawable != null)
            this.imageView.setImageDrawable(placeHolderDrawable);

        download();
    }

    @Override
    public void onSuccess(byte[] bytes) {
        super.onSuccess(bytes);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bitmap);
        if (responseNotifier != null) {
            ImageLoadCallback imageLoadCallback = (ImageLoadCallback) responseNotifier;
            imageLoadCallback.onSuccess(bitmap);
        }
    }

    @Override
    public void onError(Exception ex) {
        if (responseNotifier != null) {
            ImageLoadCallback imageLoadCallback = (ImageLoadCallback) responseNotifier;
            imageLoadCallback.onError(ex);
        }
    }

}
