package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class ScoreArrowTutorial extends Label{

    public ScoreArrowTutorial(){

    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(895, 900 - 250);
        size = new Vector2f(152, 138);
    }

    @Override
    protected void initTexture() {
        texture = SpriteLoader.tutorialArrowScore;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText("Ohrani razdaljo pod ciljem!", "#000000", 700, 900 - 250, 1000, 1f, 40);
    }
}
