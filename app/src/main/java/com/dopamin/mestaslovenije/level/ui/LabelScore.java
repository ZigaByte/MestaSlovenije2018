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

        //float score = game.getLevel().getScore();
        //r.alpha(255);
        //r.drawText((int)(score * 10) / 10f + "", "#000000", pos.x + size.x / 2, pos.y + size.y - 10, 64, Paint.Align.CENTER);
    }

}
