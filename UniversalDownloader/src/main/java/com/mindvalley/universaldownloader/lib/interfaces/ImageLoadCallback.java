package com.mindvalley.universaldownloader.lib.interfaces;

import android.graphics.Bitmap;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public interface ImageLoadCallback extends ResponseNotifier {
    void onSuccess(Bitmap bitmap);

    void onError(Exception ex);
}