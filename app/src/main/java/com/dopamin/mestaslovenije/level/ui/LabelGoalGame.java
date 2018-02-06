package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class LabelGoalGame extends Label{

    private int stageNumber;

    public LabelGoalGame(int stageNumber){
        super();
        this.stageNumber = stageNumber;
    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(1312, 900 - 270);
        size = new Vector2f(228, 67);
    }

    protected void initTexture(){
        texture = SpriteLoader.gameGoal;
    }

    @Override
    public void render(Render r) {
        super.render(r);
        int goal = (stageNumber + 1) * 75;
        r.drawText("Cilj: < " + goal + " km", "#FFFFFF", 1428, 900 - 228, 140, 1.3f, 90);
    }
}
