package ru.sberbank.homework13.recycler.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.sberbank.homework13.R;
import ru.sberbank.homework13.recycler.ViewHolder;
import ru.sberbank.homework13.recycler.ViewHolderFactory;

public class PicassoViewHolderFactory implements ViewHolderFactory {

    @Override
    public ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.image_item, parent, false);
        ViewHolder viewHolder = new PicassoViewHolder(view);
        return viewHolder;
    }
}
