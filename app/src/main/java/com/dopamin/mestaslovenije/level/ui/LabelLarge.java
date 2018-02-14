package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Ziga on 14-Feb-18.
 */

public abstract class LabelLarge extends Label{

    private String text;
    private Vector2f offset;

    public LabelLarge(String text, Vector2f offset){
        this.text = text;
        this.offset = offset;
        pos = pos.add(offset);
    }

    @Override
    protected final void initLocation() {
        pos = new Vector2f(-60, 44);
        size = new Vector2f(924, 211);
    }

    protected final void initTexture(){
        texture = SpriteLoader.gameQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText(text, "#FFFFFF", 375 + offset.x, 165 + offset.y, 650, 1.8f, 90);
    }


}
