package ru.sberbank.homework13.recycler.Glide;

import ru.sberbank.homework13.GlideApp;
import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.recycler.ViewHolder;
import ru.sberbank.homework13.recycler.ViewHolderBinder;

public class GlideHolderBinder extends ViewHolderBinder {

    private Photo mPhoto;

    public GlideHolderBinder(int viewType, Photo photo) {
        super(viewType);
        mPhoto = photo;
    }

    @Override
    public void bindViewHolder(ViewHolder viewHolder) {
        GlideViewHolder holder = (GlideViewHolder) viewHolder;
        GlideApp.with(holder.getmImageView()).load(mPhoto.getUri()).into(holder.getmImageView());
    }
}
