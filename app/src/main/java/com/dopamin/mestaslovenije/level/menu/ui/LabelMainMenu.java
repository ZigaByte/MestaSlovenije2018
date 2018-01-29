package com.dopamin.mestaslovenije.level.menu.ui;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 29. 01. 2018.
 */

public class LabelMainMenu extends Label {

    @Override
    protected void initLocation() {
        pos = new Vector2f(138, Render.HEIGHT - 860);
        size = new Vector2f(1138, 552);
    }

    protected void initTexture(){
        texture = SpriteLoader.mainMenuLabel;
    }
}
