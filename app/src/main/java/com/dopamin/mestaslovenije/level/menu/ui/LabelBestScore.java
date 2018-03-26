package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.input.DatabaseLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Ziga on 23-Feb-18.
 */

public class LabelBestScore extends Label {

    private int currentScore = 0;

    public LabelBestScore(){
        this.currentScore = DatabaseLoader.getBestScore();
    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(1103-243, 716-60);
        size = new Vector2f(436, 110);
    }

    protected void initTexture(){
        texture = SpriteLoader.gameScore;
    }

    @Override
    public void render(Render r) {
        super.render(r);

        String text = currentScore == -1 ? "-" : currentScore + " km";
        r.drawText("Rekord: " + text, "#FFFFFF", pos.x + 217, pos.y + 68, 300, -0.5f, 60);

    }
}
