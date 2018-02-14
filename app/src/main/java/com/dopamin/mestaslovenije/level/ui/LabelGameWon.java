package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 31. 01. 2018.
 */

public class LabelGameWon extends LabelLarge{

    public LabelGameWon(boolean won){
        super(won ? "Zmaga!" : "Konec igre!", new Vector2f(0, 0));
    }

}
