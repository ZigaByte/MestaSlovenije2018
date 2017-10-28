package com.dopamin.mestaslovenije.level.ui;


import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.math.Vector2f;

public class LabelScore extends Label {

    @Override
    protected void initLocation() {
        pos = new Vector2f(1000, 900 - 150);
        size = new Vector2f(500, 100);
    }

    @Override
    public void render(Render r) {
        super.render(r);

        float score = game.getLevel().getScore();
        r.alpha(128);
        r.drawText("Točke", "#000000", pos.x + size.x / 2, pos.y  - 10, 50, Paint.Align.CENTER);
        r.alpha(255);
        r.drawText((int)(score * 10) / 10f + "", "#000000", pos.x + size.x / 2, pos.y + size.y - 10, 64, Paint.Align.CENTER);
    }

}
