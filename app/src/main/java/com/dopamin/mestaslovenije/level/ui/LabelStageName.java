package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 31. 01. 2018.
 */

public class LabelStageName extends Label{

    @Override
    protected void initLocation() {
        pos = new Vector2f(-60 + 300, 44 + 300);
        size = new Vector2f(924, 211);
    }

    protected void initTexture(){
        texture = SpriteLoader.gameQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText(game.getLevel().getStageName(), "#FFFFFF", 375 + 300, 165 + 300, 650, 1.8f, 90);
    }
}
