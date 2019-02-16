package ru.sberbank.homework13.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.sberbank.homework13.entity.ItemTypes;
import ru.sberbank.homework13.entity.Photo;
import ru.sberbank.homework13.recycler.Fresco.FrescoHolderBinder;
import ru.sberbank.homework13.recycler.Fresco.FrescoHolderFactory;
import ru.sberbank.homework13.recycler.Glide.GlideHolderBinder;
import ru.sberbank.homework13.recycler.Glide.GlideHolderFactory;
import ru.sberbank.homework13.recycler.HttpUrlConnection.HttpHolderBinder;
import ru.sberbank.homework13.recycler.HttpUrlConnection.HttpHolderFactory;
import ru.sberbank.homework13.recycler.Picasso.PicassoViewHolderBinder;
import ru.sberbank.homework13.recycler.Picasso.PicassoViewHolderFactory;

public class ImageAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<ViewHolderBinder> mBinders;
    private List<Photo> mData;
    private SparseArray<ViewHolderFactory> mFactoryMap;

    public ImageAdapter() {
        mBinders = new ArrayList<>();
        mData = new ArrayList<>();
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ItemTypes.PICASSO.getType(), new PicassoViewHolderFactory());
        mFactoryMap.put(ItemTypes.GLIDE.getType(), new GlideHolderFactory());
        mFactoryMap.put(ItemTypes.FRESCO.getType(), new FrescoHolderFactory());
        mFactoryMap.put(ItemTypes.HTTP.getType(), new HttpHolderFactory());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolderFactory factory = mFactoryMap.get(i);
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return factory.createViewHolder(viewGroup, inflater);
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    public void setData(List<Photo> items) {
        mData.clear();
        mData.addAll(items);

        mBinders.clear();
        for (Photo item : mData) {
            mBinders.add(generateBinder(item));
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ViewHolderBinder binder = mBinders.get(i);
        if (binder != null) {
            binder.bindViewHolder(viewHolder);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private ViewHolderBinder generateBinder(Photo photo) {
        if (photo.getType() == ItemTypes.PICASSO.getType()) {
            return new PicassoViewHolderBinder(ItemTypes.PICASSO.getType(), photo);
        } else if (photo.getType() == ItemTypes.FRESCO.getType())
            return new FrescoHolderBinder(ItemTypes.FRESCO.getType(), photo);
        else if (photo.getType() == ItemTypes.GLIDE.getType())
            return new GlideHolderBinder(ItemTypes.GLIDE.getType(), photo);
        else if (photo.getType() == ItemTypes.HTTP.getType())
            return new HttpHolderBinder(ItemTypes.HTTP.getType(), photo);
        else return null;
    }
}
