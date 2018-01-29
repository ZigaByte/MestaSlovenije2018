package com.dopamin.mestaslovenije;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.input.DatabaseHelper;
import com.dopamin.mestaslovenije.input.DatabaseSchema;
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

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.start;

public class Game extends View implements Time, Runnable {

    int updateCount = 0;

    private Render render;

    private Menu currentMenu;

    DatabaseHelper databaseHelper;
    SQLiteDatabase database;

    Input input;
    boolean running = false;

    Thread updateThread = null;

    public void setMenu(Menu menu) {
        this.currentMenu = menu;
    }

    public Game(Context context) {
        super(context);

        // Load the locations and start database
        LocationsLoader.am = context.getAssets();
        startDatabase(context);

        // Load the sprites
        SpriteLoader.loadSprites(context);

        Entity.setGame(this);

        input = new Input();
        setOnTouchListener(input);

        render = new Render(context);
        currentMenu = new MenuMain();
    }

    public void startDatabase(Context context){
        // Start the database
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
/*
        // Select all
        Cursor cursor = database.query(DatabaseSchema.Location.TABLE_NAME, null, null, null, null, null, null, null);

        // Display all the table entries
        while(cursor.moveToNext()) {
            Log.e("ENTRY !!", cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_N))
                    + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_E))+ " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_COUNT))
                    + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_STAGE_ID)));
        }
        cursor.close();
*/
    }

    public synchronized void pause(){
        running = false;
        try {
            updateThread.join();
        }catch (Exception e){

        }
    }

    public void resume(){
        updateThread = new Thread(this);
        updateThread.start();

        running = true;
    }

    public void stop(){
        running = false;
        try {
            updateThread.join();
        }catch (Exception e){

        }
    }

    @Override
    public void run() {
        //super.run();
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

    public void update(float deltaTime) {
        // Update timers
        for (int i = 0; i < timers.size(); i++) {
            Timer t = timers.get(i);
            t.update(deltaTime);
        }
        for (int i = 0; i < timers.size(); i++) {
            Timer t = timers.get(i);
            if(t.finished)
                timers.remove(t);
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
        render.drawRectangle("#637d69", 0, 0, 1600, 900);

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
