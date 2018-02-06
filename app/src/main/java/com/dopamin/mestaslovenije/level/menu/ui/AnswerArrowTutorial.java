package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class AnswerArrowTutorial extends Label{

    public AnswerArrowTutorial(){

    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(1122, 900 - 584);
        size = new Vector2f(128, 150);
    }

    @Override
    protected void initTexture() {
        texture = SpriteLoader.tutorialArrowQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText("Oglej si rezultat", "#000000", 1400, 900 - 400, 600, 1f, 40);
    }
}
