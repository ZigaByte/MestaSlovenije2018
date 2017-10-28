package com.dopamin.mestaslovenije;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.input.Input;
import com.dopamin.mestaslovenije.input.LocationsLoader;
import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.level.menu.Menu;
import com.dopamin.mestaslovenije.level.menu.MenuLevel;
import com.dopamin.mestaslovenije.level.menu.MenuMain;
import com.dopamin.mestaslovenije.level.ui.Level;
import com.dopamin.mestaslovenije.math.Vector2f;
import com.dopamin.mestaslovenije.math.timing.Time;
import com.dopamin.mestaslovenije.math.timing.Timer;

public class Game extends View implements Time {


    private Render render;

    private Menu currentMenu;

    Input input;
    boolean running = false;

    public void setMenu(Menu menu) {
        this.currentMenu = menu;
    }


    public Game(Context context) {
        super(context);

        Entity.setGame(this);
        input = new Input();
        setOnTouchListener(input);

        render = new Render(context);

        currentMenu = new MenuMain();

        LocationsLoader.am = context.getAssets();
        SpriteLoader.loadSprites(context);

    }

    public void startGameLoop() {
        running = true;
        updateThread.start();
    }

    Thread updateThread = new Thread() {
        @Override
        public void run() {
            super.run();
            float timerStart = System.nanoTime() / 1000000000.0f;
            while (running) {
                float timerNow = System.nanoTime() / 1000000000.0f;
                if (timerNow - timerStart >= 1 / 30.0) {
                    update(timerNow - timerStart);
                    timerStart = System.nanoTime() / 1000000000.0f;
                    try{
                        Thread.sleep(15);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        }
    };

    public void update(float deltaTime) {
        // Update timers
        for (int i = 0; i < timers.size(); i++) {
            Timer t = timers.get(i);
            t.update(deltaTime);
            if (t.finished) {
                timers.remove(t);
                i--;
            }
        }

        currentMenu.update();
        currentMenu.updateChildren();
    }

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*  Checking for input.
            Input needs to be done in the main thread
            for full responsiveness.
         */
        if (Input.ready()) {
            Vector2f input = Input.get();
            currentMenu.processInput(input);
        }

        render.begin(canvas, paint);
        canvas.save();

        canvas.scale((float) Render.SCREEN_WIDTH / Render.WIDTH, (float) Render.SCREEN_HEIGHT / Render.HEIGHT);

        currentMenu.render(render);
        currentMenu.renderChildren(render);

        canvas.restore();
        invalidate();
    }

    public Level getLevel() {
        if (currentMenu instanceof MenuLevel) {
            return ((MenuLevel) currentMenu).getLevel();
        }

        System.err.println("Level not found");
        return null;
    }
}
