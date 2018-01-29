package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 29. 01. 2018.
 */

public class Background extends Label {

    @Override
    protected void initLocation() {
        pos = new Vector2f(138, Render.HEIGHT - 847);
        size = new Vector2f(1240, 819);
    }

    protected void initTexture(){
        texture = SpriteLoader.background;
    }

}
