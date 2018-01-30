package com.dopamin.mestaslovenije.level.ui;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;
import com.dopamin.mestaslovenije.math.timing.Timer;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Žiga on 30. 01. 2018.
 */

public class LabelQuestion extends Label{
    //Timer t;

    @Override
    protected void initLocation() {
        pos = new Vector2f(-60, 900 - 856);
        size = new Vector2f(924, 211);

        //timers.add(t = new Timer());
    }

    protected void initTexture(){
        texture = SpriteLoader.gameQuestion;
    }

    @Override
    public void render(Render r) {
        super.render(r);

        //r.drawText("TEST", "#FFFFFF", 300, 300, 50, Paint.Align.CENTER);
        //r.drawText("ARBORETUM VOLČJI POTOKlafsndflkansdfklansdf".substring((int)(("ARBORETUM VOLČJI POTOKlafsndflkansdfklansdf".length()-7)*Math.abs(Math.sin(t.time/ 10))) + 5), );
        r.drawText(game.getLevel().getQuestion(), "#FFFFFF", 375, 165, 650, 1.8f, 90);
    }
}
