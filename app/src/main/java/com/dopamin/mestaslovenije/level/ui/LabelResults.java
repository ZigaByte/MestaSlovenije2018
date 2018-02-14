package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 30. 01. 2018.
 */

public class LabelResults extends Label{

    private boolean passed;

    public LabelResults(boolean passed){
        this.passed = passed;
    }

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
        String text = passed ? "Stopnja opravljena" : "Cilj prekoračen!";
        r.drawText(text, "#FFFFFF", 375, 165, 650, 1.8f, 90);
    }
}
