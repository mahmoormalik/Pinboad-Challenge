package com.mindvalleychallenge.pinboardchallenge.pinboard.utils;

import android.net.Uri;

/**
 * Created by MuhammadMahmoor on 8/16/17.
 */

public class API {

    final static public String BASE_URL = "pastebin.com";

    public static String urlGetPinboard() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").authority(BASE_URL).appendPath("raw").appendPath("wgkJgazE");
        return builder.build().toString();
    }

}
