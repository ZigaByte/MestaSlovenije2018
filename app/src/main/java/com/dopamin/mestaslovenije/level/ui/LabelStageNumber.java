package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Ziga on 26-Mar-18.
 */

public class LabelStageNumber extends Label{

    private int stageNumber;

    public LabelStageNumber(int stageNumber){
        super();
        this.stageNumber = stageNumber+1;
    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(900, 900 - 620);
        size = new Vector2f(228, 67);
        rotation = 2.25f;
    }

    protected void initTexture(){
        texture = SpriteLoader.gameGoal;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        r.drawText("Stopnja " + stageNumber +"/15", "#FFFFFF", 1018, 900- 578, 150, 0, 50);
    }

}
