package com.mindvalleychallenge.pinboardchallenge.pinboard.model;

import android.support.v4.util.Pair;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.mindvalley.universaldownloader.lib.interfaces.JSONLoadCallback;
import com.mindvalleychallenge.pinboardchallenge.PinboardApplication;
import com.mindvalleychallenge.pinboardchallenge.R;
import com.mindvalleychallenge.pinboardchallenge.pinboard.interfaces.ApiResponseNotifier;
import com.mindvalleychallenge.pinboardchallenge.pinboard.utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

import static com.mindvalleychallenge.pinboardchallenge.PinboardApplication.context;
import static com.mindvalleychallenge.pinboardchallenge.PinboardApplication.realm;

/**
 * Created by MuhammadMahmoor on 8/16/17.
 */

public class PinImage extends RealmObject {

    @PrimaryKey
    String id;

    @SerializedName("raw")
    String rawImage;
    @SerializedName("small")
    String smallImage;
    @SerializedName("regular")
    String regularImage;
    @SerializedName("full")
    String fullImage;
    @SerializedName("thumb")
    String thumbImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRawImage() {
        return rawImage;
    }

    public void setRawImage(String rawImage) {
        this.rawImage = rawImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getRegularImage() {
        return regularImage;
    }

    public void setRegularImage(String regularImage) {
        this.regularImage = regularImage;
    }

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public static RealmResults<PinImage> getAllPins(Realm realm) {
        return realm.where(PinImage.class).findAll();
    }


    public static void fetchPins(String url, final ApiResponseNotifier apiResponseNotifier) {

        PinboardApplication.getUniversalDownloader().loadJSON(url, new JSONLoadCallback() {
            @Override
            public void onSuccess(final String response) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Log.i(AppConstants.TAG, "response = "+response);
                        try {
                            JSONArray responseArray = new JSONArray(response);
                            Gson gson = new GsonBuilder().create();
                            Type collectionType = new TypeToken<PinImage>() {
                            }.getType();
                            for(int i=0; i<responseArray.length(); i++) {
                                JSONObject item = responseArray.getJSONObject(i);
                                String id = item.optString("id");
                                JSONObject url = item.getJSONObject("urls");
                                if(url != null)
                                {   url.put("id", id); // Setting item id in url object so GSON can do POJO
                                    PinImage pinImage = gson.fromJson(url.toString(), collectionType); // Using GSON to convert JSON object into Java object because realm does not recognize @SerializedName
                                    realm.copyToRealmOrUpdate(pinImage);
                                }
                            }

                            apiResponseNotifier.onSuccess(getAllPins(realm));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            apiResponseNotifier.onError(new Pair<String, String>(context.getString(R.string.error_title_server_unknown_response), context.getString(R.string.error_desc_server_unknown_response)), getAllPins(realm));
                        }
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                Log.i(AppConstants.TAG, "response  onError= "+e.getMessage());

                apiResponseNotifier.onError(new Pair<String, String>(context.getString(R.string.error_title_server_not_accessible), context.getString(R.string.error_desc_server_not_accessible)), getAllPins(realm));
            }
        });
    }



}
