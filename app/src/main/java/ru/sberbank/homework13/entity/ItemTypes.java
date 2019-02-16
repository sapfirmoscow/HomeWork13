package ru.sberbank.homework13.entity;


public enum ItemTypes {
    PICASSO(0), FRESCO(1), GLIDE(2), HTTP(3);

    private int type;

    ItemTypes(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
