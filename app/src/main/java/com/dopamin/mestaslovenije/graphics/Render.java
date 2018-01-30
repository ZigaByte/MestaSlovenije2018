package com.dopamin.mestaslovenije.graphics;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.TextureView;
import android.view.WindowManager;

public class Render {

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 900;

    Canvas canvas;
    Paint paint;

    private Typeface regular, bold;

    int alpha = 255;

    public Render(Context context) {
        /*
           Get actual screen dimensions - it depends on Android version,
           because of the navigation bar
        */
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            display.getRealSize(size);
            SCREEN_WIDTH = size.x;
            SCREEN_HEIGHT = size.y;
        } else {
            display.getSize(size);
            SCREEN_WIDTH = size.x;
            SCREEN_HEIGHT = size.y;
        }

        regular = Typeface.createFromAsset(context.getAssets(), "fonts/typo_regular.otf");
        //bold = Typeface.createFromAsset(context.getAssets(), "fonts/roboto_bold.ttf");
        //regular = Typeface.create("Roboto", Typeface.NORMAL);
    }

    // Get fresh canvas and paint objects
    public void begin(Canvas canvas, Paint paint) {
        this.canvas = canvas;
        this.paint = paint;

        paint.setAntiAlias(true);
        paint.setTypeface(regular);
    }

    // Get alpha
    public int alpha (){
        return alpha;
    }

    // Set alpha
    public void alpha(int a){
        alpha = a;
    }

    public void drawText(String text, String color, float x, float y, int width, float rotation, int maxSize){
        text = text.replace('.', ',');
        if(text.length() <= 0)return;

        Rect bounds = new Rect();
        paint.setTextSize(10);
        paint.getTextBounds(text, 0, text.length() - 1, bounds);

        float newSize = paint.getTextSize() * width / bounds.right;
        newSize = Math.min(newSize, maxSize);

        canvas.save();
        canvas.translate(x, y);
        canvas.rotate(-rotation);

        paint.setColor(Color.parseColor(color));
        paint.setTextSize(newSize);
        canvas.drawText(text, 0, 0, paint);

        canvas.restore();
    }

    public void drawText(String text, String color, float x, float y, int size, Paint.Align align) {
        text = text.replace('.', ',');
        paint.setColor(Color.parseColor(color));
        paint.setAlpha(alpha);
        paint.setTextSize(size);
        paint.setTextAlign(align);
        canvas.drawText(text, x, y, paint);
    }

    public void drawPolygon(Polygon p) {
        drawPolygon(p, "#FFFFFF", 0, 0, 0);
    }

    public void drawPolygon(Polygon p, float x, float y) {
        drawPolygon(p, "#FFFFFF", x, y, 0);
    }

    public void drawPolygon(Polygon p, String color, float x, float y) {
        drawPolygon(p, color, x, y, 0);
    }

    /**
     * @param x        the x offset. X will be the center of the polygon
     * @param y        the y offset. Y will be the center of the polygon
     * @param rotation rotation of the polygon in radians
     */
    public void drawPolygon(Polygon p, String color, float x, float y, float rotation) {
        if(p.VERTICES_COUNT <= 0) return;

        canvas.save();
        canvas.translate(x, y);
        canvas.rotate(rotation * 180 / 3.14f); // Convert to degrees

        paint.setColor(Color.parseColor(color));
        paint.setAlpha(alpha);
        paint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD); // Odd number of vertices
        path.moveTo(p.VERTICES[0].x, p.VERTICES[0].y);

        // Draw the individual vertices triangles with vertices
        for (int i = 0; i < p.VERTICES_COUNT; i += 1) {
            path.lineTo(p.VERTICES[i].x, p.VERTICES[i].y);
        }

        path.lineTo(p.VERTICES[0].x, p.VERTICES[0].y);
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    public void drawRectangle(String color, float x, float y, float w, float h) {
        paint.setColor(Color.parseColor(color));
        canvas.save();
        canvas.translate(x + w / 2, y + h / 2);
        canvas.drawRect(-w / 2, -h / 2, w / 2, h / 2, paint);
        canvas.restore();
    }

    public void drawCirlce(String color, float x, float y, float radius) {
        paint.setColor(Color.parseColor(color));
        canvas.drawCircle(x, y, radius, paint);
    }

    public void drawLine(String color, float x0, float y0, float x1, float y1) {
        paint.setStrokeWidth(4);
        paint.setColor(Color.parseColor(color));
        canvas.drawLine(x0, y0, x1, y1, paint);
    }

    public void drawTexture(Bitmap texture, float x, float y, float w, float h) {
        drawTexture(texture, x, y, w, h, 0);
    }

    public void drawTexture(Bitmap texture, float x, float y, float w, float h, float rotation) {

        //TODO: Remove Bitmap scaling every time it gets drawn!!!
        //Bitmap scaled = Bitmap.createScaledBitmap(texture, (int) w, (int) h, true);

        // The draw method requires rotation in degrees.
        rotation = rotation * 180f / 3.14f;
        canvas.save();
        canvas.translate(x + w / 2, y + h / 2);
        canvas.rotate(rotation);
        Log.e(texture.getWidth()+ " ", texture.getHeight() + " ");

        canvas.scale(w/texture.getWidth(), h / texture.getHeight());
        canvas.drawBitmap(texture, -w / 2, -h / 2, paint);

        canvas.restore();
    }

}
