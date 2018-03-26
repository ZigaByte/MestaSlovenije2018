package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Ziga on 26-Mar-18.
 */

public class PressAnywhere extends UIElement{

    @Override
    public void update() {}

    @Override
    protected void initLocation() {}

    protected void initTexture() {}

    @Override
    public void render(Render r) {
        r.drawText("Pritisni kamorkoli, da nadaljuješ", "#000000", 1320, 860, 350, -0.5f, 60);

    }


}
