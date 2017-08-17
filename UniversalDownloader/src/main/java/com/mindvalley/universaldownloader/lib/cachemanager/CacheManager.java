package com.mindvalley.universaldownloader.lib.cachemanager;

import android.util.LruCache;

/**
 * Created by MuhammadMahmoor on 8/15/17.
 */


public class CacheManager {
    // LruCache will handle auto eviction of least recently used object if needed
    private LruCache<String, byte[]> downladedContentCache;
    private static CacheManager instance;


    private CacheManager(int maxCacheSize) {
        downladedContentCache = new LruCache<>(maxCacheSize);
    }

    public static CacheManager getInstance(int maxCache) {
        if (instance == null) {
            instance = new CacheManager(maxCache);
        }
        return instance;
    }

    public static CacheManager getInstance() {
        return instance;
    }


    public void clearCash() {
        downladedContentCache.evictAll();
    }

    public byte[] getContentFromCache(String key) {
        return downladedContentCache.get(key);
    }

    public boolean putContentToCache(String key, byte[] bytes) {
        return downladedContentCache.put(key, bytes) != null;
    }
}
