package com.dopamin.mestaslovenije.level.ui;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 30. 01. 2018.
 */

public class LabelQuestion extends Label{

    @Override
    protected void initLocation() {
        pos = new Vector2f(-60, 900 - 856);
        size = new Vector2f(924, 211);
    }

    protected void initTexture(){
        texture = SpriteLoader.gameQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);
    }
}
