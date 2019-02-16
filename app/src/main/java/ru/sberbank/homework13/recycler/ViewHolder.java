package ru.sberbank.homework13.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import ru.sberbank.homework13.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.image_item_imageView);
    }

    public ImageView getmImageView() {
        return mImageView;
    }
}
