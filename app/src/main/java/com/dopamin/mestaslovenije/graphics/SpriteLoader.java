package com.dopamin.mestaslovenije.graphics;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.dopamin.mestaslovenije.R;

public class SpriteLoader {

    public static Bitmap background;

    public static void loadSprites(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background);
    }
}
