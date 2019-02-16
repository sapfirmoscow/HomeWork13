package ru.sberbank.homework13.recycler.HttpUrlConnection;

import android.widget.ImageView;

import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.recycler.ViewHolder;
import ru.sberbank.homework13.recycler.ViewHolderBinder;

public class HttpHolderBinder extends ViewHolderBinder {

    private Photo mPhoto;

    public HttpHolderBinder(int viewType, Photo photo) {
        super(viewType);
        mPhoto = photo;
    }

    @Override
    public void bindViewHolder(ViewHolder viewHolder) {
        HttpViewHolder holder = (HttpViewHolder) viewHolder;
        String url = mPhoto.getUri().toString();
        holder.getmImageView().setScaleType(ImageView.ScaleType.FIT_XY);
        new GetImageAsyncTask(url, bitmap -> holder.getmImageView().setImageBitmap(bitmap)).execute();

    }
}
