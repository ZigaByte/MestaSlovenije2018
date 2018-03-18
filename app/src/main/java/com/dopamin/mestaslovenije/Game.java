package com.dopamin.mestaslovenije;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.input.DatabaseHelper;
import com.dopamin.mestaslovenije.input.Input;
import com.dopamin.mestaslovenije.input.LocationsLoader;
import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.level.menu.Menu;
import com.dopamin.mestaslovenije.level.menu.MenuLevel;
import com.dopamin.mestaslovenije.level.menu.MenuMain;
import com.dopamin.mestaslovenije.level.Level;
import com.dopamin.mestaslovenije.math.Vector2f;

public class Game extends View {

    int updateCount = 0;

    private Render render;

    private Menu currentMenu;

    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    public ServicesController services;

    Input input;
    boolean running = false;

    public void setMenu(Menu menu) {
        this.currentMenu = menu;
    }

    public Game(Context context)
    {
        super(context);
    }
    public Game(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    public Game(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(Context context, ServicesController services){
        this.services = services;

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
        if(render != null){
            render.begin(canvas, paint);
            canvas.save();

            canvas.scale((float) Render.SCREEN_WIDTH / Render.WIDTH, (float) Render.SCREEN_HEIGHT / Render.HEIGHT);
            render.drawRectangle("#9b9b9b", 0, 0, 1600, 900);

            currentMenu.render(render);
            currentMenu.renderChildren(render);

            canvas.restore();
        }
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
