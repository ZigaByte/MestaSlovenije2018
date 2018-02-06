package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class LabelGoal extends Label{

    private int stageNumber;

    public LabelGoal(int stageNumber){
        super();
        this.stageNumber = stageNumber;
    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(770, 900 - 375);
        size = new Vector2f(382, 94);
    }

    protected void initTexture(){
        texture = SpriteLoader.labelGoal;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        int goal = (stageNumber + 1) * 75;
        r.drawText("Cilj: < " + goal + " km", "#FFFFFF", 970, 585, 225, 0.1f, 90);
    }
}
