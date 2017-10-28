package com.dopamin.mestaslovenije.level.ui;


import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.Rhomboid;
import com.dopamin.mestaslovenije.math.Vector2f;

public abstract class Label extends UIElement {

    protected Vector2f pos;
    protected Vector2f size;

    public Label() {
        initLocation();
    }

    protected abstract void initLocation();

    @Override
    protected void loadTexture() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {
        r.drawPolygon(new Rhomboid(size.x, size.y), green, pos.x, pos.y);
    }
}
