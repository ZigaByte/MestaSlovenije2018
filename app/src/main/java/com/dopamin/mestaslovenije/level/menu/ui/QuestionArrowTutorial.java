package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class QuestionArrowTutorial extends Label{

    public QuestionArrowTutorial(){

    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(551, 900 - 655);
        size = new Vector2f(128, 150);
    }

    @Override
    protected void initTexture() {
        texture = SpriteLoader.tutorialArrowQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText("Lokacijo z dotikom poišči na karti!", "#000000", 650, 900 - 460, 1000, 1f, 40);
    }
}
