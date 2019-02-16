package ru.sberbank.homework13.entity;

import android.net.Uri;


public class Photo {
    private String mUriToParse;
    private int mType;

    public Photo(String url, int type) {
        mUriToParse = url;
        mType = type;

    }

    public Uri getUri() {
        return Uri.parse(mUriToParse);
    }

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }
}

