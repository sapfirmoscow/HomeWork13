package ru.sberbank.homework13.recycler.HttpUrlConnection;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class GetImageAsyncTask extends AsyncTask<Void, Void, Bitmap> {

    private final Callback mCallback;
    private final String mUrl;

    GetImageAsyncTask(String url, Callback callback) {
        mUrl = url;
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {

        MyHttpUrlConnection myHttpUrlConnection = new MyHttpUrlConnection();
        Bitmap bitmap = myHttpUrlConnection.getImage(mUrl);
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mCallback.callback(bitmap);
    }

    public interface Callback {
        void callback(Bitmap bitmap);
    }
}
