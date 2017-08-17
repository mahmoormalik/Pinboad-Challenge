package com.mindvalley.universaldownloader.lib.interfaces;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public interface DownloadResponseListener {

    void onSuccess(byte[] bytes);
    void onError(Exception ex);
}
