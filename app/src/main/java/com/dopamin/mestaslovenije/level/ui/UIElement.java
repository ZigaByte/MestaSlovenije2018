package com.dopamin.mestaslovenije.level.ui;

import android.graphics.Bitmap;

import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.math.Rectangle;
import com.dopamin.mestaslovenije.math.Vector2f;

public abstract class UIElement extends Entity {

    public static final String green = "#7BC600";

    protected Vector2f pos;
    protected Vector2f size;

    protected Rectangle rectangle;

    protected Bitmap texture;

    public UIElement() {
        pos = new Vector2f();
        size = new Vector2f();
        rectangle = new Rectangle(pos, pos.add(size));

        loadTexture();
    }

    protected abstract void loadTexture();

}
