package com.dopamin.mestaslovenije.level.ui;


import android.graphics.Bitmap;
import android.util.Log;

import com.dopamin.mestaslovenije.graphics.Polygon;
import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.Rhomboid;
import com.dopamin.mestaslovenije.math.Vector2f;

public abstract class Label extends UIElement {

    protected Vector2f pos;
    protected Vector2f size;
    protected float rotation;

    public Label() {
        super();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {
        r.drawTexture(texture, pos.x, pos.y, size.x, size.y, rotation);
    }
}
