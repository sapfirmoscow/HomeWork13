package ru.sberbank.homework13.recycler.Fresco;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import ru.sberbank.homework13.R;
import ru.sberbank.homework13.recycler.ViewHolder;

public class FrescoViewHolder extends ViewHolder {
    private SimpleDraweeView mSimpleDraweeView;

    public FrescoViewHolder(@NonNull View itemView) {
        super(itemView);
        mSimpleDraweeView = itemView.findViewById(R.id.image_item_simpleDraweeView);
    }

    public SimpleDraweeView getmSimpleDraweeView() {
        return mSimpleDraweeView;
    }

    @Deprecated
    @Override
    public ImageView getmImageView() {
        return super.getmImageView();
    }
}
