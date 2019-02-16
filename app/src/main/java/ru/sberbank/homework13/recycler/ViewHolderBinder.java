package ru.sberbank.homework13.recycler;

public abstract class ViewHolderBinder {

    protected final int mViewType;

    public ViewHolderBinder(int viewType) {
        mViewType = viewType;
    }

    public abstract void bindViewHolder(ViewHolder viewHolder);
}
