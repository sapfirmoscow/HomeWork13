package ru.sberbank.homework13.recycler.Picasso;

import com.squareup.picasso.Picasso;

import ru.sberbank.homework13.R;
import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.recycler.ViewHolder;
import ru.sberbank.homework13.recycler.ViewHolderBinder;

public class PicassoViewHolderBinder extends ViewHolderBinder {

    private Photo mPhoto;

    public PicassoViewHolderBinder(int viewType, Photo photo) {
        super(viewType);
        mPhoto = photo;
    }

    @Override
    public void bindViewHolder(ViewHolder viewHolder) {
        PicassoViewHolder holder = (PicassoViewHolder) viewHolder;
        Picasso.get().load(mPhoto.getUri()).placeholder(R.drawable.ic_launcher_background).into(holder.getmImageView());
    }


}
