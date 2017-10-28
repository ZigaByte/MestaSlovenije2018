package com.dopamin.mestaslovenije.input;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.math.Vector2f;

import java.util.ArrayList;

public class Input implements View.OnTouchListener {

    //private boolean fullscreen = false;

    public static ArrayList<Vector2f> inputs = new ArrayList<Vector2f>();

    public static boolean ready() {
        return inputs.size() > 0;
    }

    public static Vector2f get() {
        if (ready()) {
            Vector2f input = inputs.get(0);
            inputs.remove(input);
            return input;
        }
        //System.out.println("INPUT NOT READY");
        return null;
    }

    @Override
    public boolean onTouch(View view, MotionEvent e) {
        int x = (int) (( e.getX() / Render.SCREEN_WIDTH) * Render.WIDTH);
        int y = (int) (Render.HEIGHT - ((e.getY()) / Render.SCREEN_HEIGHT) * Render.HEIGHT);
        inputs.add(new Vector2f(x, y));
        return false;
    }
}