package ru.sberbank.homework13.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public interface ViewHolderFactory {

    /**
     * Метод создания конкретного ViewHolder
     *
     * @param parent   родительская вью
     * @param inflater {@link LayoutInflater} для получения объекта вьхи из xml
     * @return готовый объект класса {@link ViewHolder}
     */

    ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater);
}
