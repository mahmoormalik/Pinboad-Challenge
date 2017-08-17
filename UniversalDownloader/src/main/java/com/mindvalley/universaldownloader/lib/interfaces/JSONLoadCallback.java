package com.mindvalley.universaldownloader.lib.interfaces;


/**
 * Created by MuhammadMahmoor on 8/15/17.
 */

public interface JSONLoadCallback extends ResponseNotifier {
    void onSuccess(String response);

    void onError(Exception ex);
}