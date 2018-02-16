package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.MainActivity;
import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.menu.MenuLevel;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 29. 01. 2018.
 */

public class ButtonLeaderboard extends Button {

    @Override
    protected void pressed() {
        MainActivity.getGame().services.showLeaderboard();
    }

    @Override
    protected void initLocation() {
        pos = new Vector2f(874, Render.HEIGHT - 303);
        size = new Vector2f(433, 110);
    }

    protected void initTexture(){
        texture = SpriteLoader.buttonLeaderboard;
    }

    @Override
    public void render(Render r) {
        super.render(r);

    }

}
