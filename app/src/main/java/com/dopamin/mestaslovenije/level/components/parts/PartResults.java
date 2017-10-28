package com.dopamin.mestaslovenije.level.components.parts;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

public class PartResults extends Part {

    public PartResults(Stage stage) {
        super(stage);
    }

    @Override
    public boolean processInput(Vector2f pos) {
        stage.complete();
        return true;
    }

    @Override
    public void render(Render r) {
        r.drawText("Rezultati", "#000000", Render.WIDTH / 4, 100, 64, Paint.Align.CENTER);

        // Draw all the lines between the results and such
        for (int i = 0; i < stage.questionsPerStage; i++) {
            Question q = stage.getQuestion(i);
            Coordinate answer = q.answer;
            Coordinate correct = q.location.coordinate;

            r.drawLine("#000000", correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
            r.drawCirlce("#00FF00", correct.IMAGE_X, correct.IMAGE_Y, 10);
            r.drawCirlce("#FF0000", answer.IMAGE_X, answer.IMAGE_Y, 10);
            r.drawText(q.location.name, "#000000", correct.IMAGE_X + 10, correct.IMAGE_Y + ((correct.IMAGE_Y - answer.IMAGE_Y < 0) ? -10 : 30), 32, Paint.Align.CENTER);
        }
    }

}
