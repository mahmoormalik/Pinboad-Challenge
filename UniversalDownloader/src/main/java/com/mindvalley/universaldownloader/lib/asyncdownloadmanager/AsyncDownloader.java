package com.mindvalley.universaldownloader.lib.asyncdownloadmanager;

import android.os.AsyncTask;
import android.support.v4.util.Pair;

import com.mindvalley.universaldownloader.lib.interfaces.DownloadResponseListener;
import com.mindvalley.universaldownloader.lib.interfaces.ResponseNotifier;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by MuhammadMahmoor on 8/14/17.
 */

public class AsyncDownloader extends AsyncTask<String, Void, Pair<byte[], Exception>> {

    DownloadResponseListener downloadResponseListener;
    ResponseNotifier responseNotifier;
    public AsyncDownloader(DownloadResponseListener downloadResponseListener) {
        this.downloadResponseListener = downloadResponseListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Pair<byte[], Exception> doInBackground(String... URL) {

        String remoteResourceURL = URL[0];

        try {

            InputStream input = new java.net.URL(remoteResourceURL).openStream();
            byte[] bytes = getBytesFromInputStream(input);
            return new Pair<>(bytes, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>(null, e);
        }
    }

    @Override
    protected void onPostExecute(Pair<byte[], Exception> result) {
        if(result.first != null) {
            downloadResponseListener.onSuccess(result.first);
        } else {
            downloadResponseListener.onError(result.second);
        }
    }

    public static byte[] getBytesFromInputStream(InputStream is) throws IOException
    {
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();)
        {
            byte[] buffer = new byte[0xFFFF];

            for (int len; (len = is.read(buffer)) != -1;)
                os.write(buffer, 0, len);

            os.flush();

            return os.toByteArray();
        }
    }
}

