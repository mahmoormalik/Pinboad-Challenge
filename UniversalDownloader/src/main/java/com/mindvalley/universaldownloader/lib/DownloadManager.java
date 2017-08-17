package com.mindvalley.universaldownloader.lib;

import android.content.Context;
import com.mindvalley.universaldownloader.lib.asyncdownloadmanager.AsyncDownloader;
import com.mindvalley.universaldownloader.lib.cachemanager.CacheManager;
import com.mindvalley.universaldownloader.lib.interfaces.DownloadResponseListener;
import com.mindvalley.universaldownloader.lib.interfaces.ResponseNotifier;


/**
 * Created by MuhammadMahmoor on 8/14/17.
 */

// DownloadManager is responsible to provide image to view either from cache or from server
public class DownloadManager implements DownloadResponseListener {

    Context context;
    String remoteResourceURL;
    protected ResponseNotifier responseNotifier;

    public DownloadManager() {

    }

    public DownloadManager(Context context, String remoteResourceURL, ResponseNotifier reponseNotifier) {
        this.context = context;
        this.remoteResourceURL = remoteResourceURL;
        this.responseNotifier = reponseNotifier;
    }

    protected void download() {
        byte[] cachedContent = CacheManager.getInstance().getContentFromCache(remoteResourceURL);
        if (cachedContent == null)
            new AsyncDownloader(this).execute(remoteResourceURL);
        else {
            onSuccess(cachedContent);
        }
    }

    @Override
    public void onSuccess(byte[] bytes) {
        if (CacheManager.getInstance().getContentFromCache(remoteResourceURL) == null)
            CacheManager.getInstance().putContentToCache(remoteResourceURL, bytes);
    }

    @Override
    public void onError(Exception ex) {
    }

}
