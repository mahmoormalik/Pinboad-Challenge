package com.mindvalleychallenge.pinboardchallenge.pinboard.interfaces;

import android.support.v4.util.Pair;

import io.realm.RealmResults;

/**
 * Created by MuhammadMahmoor on 8/16/17.
 */

public interface ApiResponseNotifier {

    void onSuccess(RealmResults realmResults);
    void onError(Pair<String, String> error, RealmResults realmResults);
}
