package ru.sberbank.homework13.recycler.Fresco;

import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.recycler.ViewHolder;
import ru.sberbank.homework13.recycler.ViewHolderBinder;

public class FrescoHolderBinder extends ViewHolderBinder {

    private Photo mPhoto;

    public FrescoHolderBinder(int viewType, Photo photo) {
        super(viewType);
        mPhoto = photo;
    }

    @Override
    public void bindViewHolder(ViewHolder viewHolder) {
        FrescoViewHolder holder = (FrescoViewHolder) viewHolder;
        holder.getmSimpleDraweeView().setImageURI(mPhoto.getUri());
    }
}
