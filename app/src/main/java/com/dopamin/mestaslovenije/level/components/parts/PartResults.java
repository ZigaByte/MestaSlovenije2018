package com.dopamin.mestaslovenije.level.components.parts;

import android.graphics.Bitmap;
import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.ui.LabelGoalGame;
import com.dopamin.mestaslovenije.level.ui.LabelResults;
import com.dopamin.mestaslovenije.level.ui.LabelScore;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

import static android.view.View.X;

public class PartResults extends Part {

    Bitmap textureCorrect;
    Bitmap textureAnswer;

    public PartResults(Stage stage, boolean passed) {
        super(stage);

        textureAnswer = SpriteLoader.gameAnswer;
        textureCorrect = SpriteLoader.gameCorrect;

        children.add(new LabelScore(stage.getLevel().getScore()));
        children.add(new LabelResults(passed));
        children.add(new LabelGoalGame(stage.stageNumber));
    }

    @Override
    public boolean processInput(Vector2f pos) {
        stage.complete();
        return true;
    }

    @Override
    public void render(Render r) {
        // Draw all the lines
        for (int i = 0; i < stage.questionsPerStage; i++) {
            Question q = stage.getQuestion(i);
            Coordinate answer = q.answer;
            Coordinate correct = q.location.coordinate;

            r.drawLine("#000000", correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
        }
        // Draw the points
        int sizeX = 42, sizeY = 63;
        for (int i = 0; i < stage.questionsPerStage; i++) {
            Question q = stage.getQuestion(i);
            Coordinate answer = q.answer;
            Coordinate correct = q.location.coordinate;
            if (answer.IMAGE_Y > correct.IMAGE_Y) {
                r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
                r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
            } else {
                r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
                r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
            }

        }
        // Draw the distances
        for (int i = 0; i < stage.questionsPerStage; i++) {
            Question q = stage.getQuestion(i);
            Coordinate answer = q.answer;
            Coordinate correct = q.location.coordinate;
            r.drawText((String.format("%.1f", q.score) + " km").replace('.', ','), "#FFFFFF", correct.IMAGE_X, correct.IMAGE_Y - sizeY, 5000, -1, 30);
        }
    }
}
