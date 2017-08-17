package com.mindvalley.universaldownloader.lib;

import android.content.Context;

import com.mindvalley.universaldownloader.lib.cachemanager.CacheManager;
import com.mindvalley.universaldownloader.lib.requesttypes.ImageRequest;
import com.mindvalley.universaldownloader.lib.requesttypes.JSONRequest;
import com.mindvalley.universaldownloader.lib.interfaces.ImageLoadCallback;
import com.mindvalley.universaldownloader.lib.interfaces.JSONLoadCallback;


/**
 * Created by MuhammadMahmoor on 8/14/17.
 */

public class UniversalDownloader {
    private Context context;
    private int maxAllocatedMemory;


    public UniversalDownloader(Context context, int maxAllocatedMemory) {
        this.context = context;
        this.maxAllocatedMemory = maxAllocatedMemory;
        CacheManager.getInstance(maxAllocatedMemory);
    }

    public CacheManager getCashManager() {
        return CacheManager.getInstance();
    }

    public static UniversalDownloader getInstance(Context context, int maxAllocatedMemory) {
        return new UniversalDownloader(context, maxAllocatedMemory);
    }

    public ImageRequest loadImage(String url, ImageLoadCallback imageLoadCallback) {
        return new ImageRequest(context, url, imageLoadCallback);
    }

    public ImageRequest loadImage(String url) {
        return new ImageRequest(context, url, null);
    }

    public JSONRequest loadJSON(String url, JSONLoadCallback jsonLoadCallback) {
        return new JSONRequest(context, url, jsonLoadCallback);
    }

}
