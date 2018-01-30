package com.dopamin.mestaslovenije.level.ui;


import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.Rhomboid;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

public class LabelScore extends Label {

    @Override
    protected void initLocation() {
        pos = new Vector2f(1103, 900 - 194);
        size = new Vector2f(436, 110);
    }

    protected void initTexture(){
        texture = SpriteLoader.gameScore;
    }

    @Override
    public void render(Render r) {
        super.render(r);

        float score = game.getLevel().getScore();
        r.drawText((String.format("%.2f", score) + " km").replace('.', ','), "#FFFFFF", 1320, 780, 300, -1, 60);
    }

}
