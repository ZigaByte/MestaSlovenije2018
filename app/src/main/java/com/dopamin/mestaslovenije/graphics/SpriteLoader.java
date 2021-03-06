package com.dopamin.mestaslovenije.graphics;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.dopamin.mestaslovenije.R;

public class SpriteLoader {

    public static Bitmap background;

    public static Bitmap buttonPlay;
    public static Bitmap buttonAbout;
    public static Bitmap buttonInstructions;
    public static Bitmap buttonLeaderboard;
    public static Bitmap mainMenuLabel;

    public static Bitmap gameScore;
    public static Bitmap gameQuestion;
    public static Bitmap gameAnswer;
    public static Bitmap gameCorrect;
    public static Bitmap gameGoal;

    public static Bitmap labelGoal;

    public static Bitmap tutorialArrowQuestion;
    public static Bitmap tutorialArrowScore;

    public static void loadSprites(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.slovenia);
        buttonPlay = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_play);
        buttonAbout = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_about);
        buttonInstructions = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_instructions);
        buttonLeaderboard = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_leaderboard);
        mainMenuLabel = BitmapFactory.decodeResource(context.getResources(), R.drawable.main_menu_label);

        gameScore = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_score);
        gameQuestion = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_question);
        gameAnswer = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_false);
        gameCorrect = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_true);
        gameGoal = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_goal);

        labelGoal = BitmapFactory.decodeResource(context.getResources(), R.drawable.label_goal);

        tutorialArrowQuestion = BitmapFactory.decodeResource(context.getResources(), R.drawable.tutorial_arrow_question);
        tutorialArrowScore = BitmapFactory.decodeResource(context.getResources(), R.drawable.tutorial_arrow_score);

    }
}
