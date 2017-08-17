package com.mindvalley.universaldownloader.lib.requesttypes;

import android.content.Context;

import com.mindvalley.universaldownloader.lib.DownloadManager;
import com.mindvalley.universaldownloader.lib.interfaces.JSONLoadCallback;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public class JSONRequest extends DownloadManager {


    public JSONRequest(Context context, String imageURL, JSONLoadCallback jsonLoadCallback) {
        super(context, imageURL, jsonLoadCallback);
        download();
    }

    @Override
    public void onSuccess(byte[] bytes) {
        super.onSuccess(bytes);
        if (responseNotifier != null) {
            JSONLoadCallback jsonLoadCallback = (JSONLoadCallback) responseNotifier;
            jsonLoadCallback.onSuccess(new String(bytes));
        }
    }

    @Override
    public void onError(Exception ex) {
        if (responseNotifier != null) {
            JSONLoadCallback jsonLoadCallback = (JSONLoadCallback) responseNotifier;
            jsonLoadCallback.onError(ex);
        }
    }
}
