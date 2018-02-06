package com.dopamin.mestaslovenije.level.components.parts;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.ui.LabelGoalGame;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;
import com.dopamin.mestaslovenije.level.ui.LabelScore;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

public class PartQuestion extends Part {

    private Question question;
    public final int questionNumber;

    private Coordinate answer;

    public PartQuestion(Stage stage, Question question, int questionNumber) {
        super(stage);
        this.question = question;
        this.questionNumber = questionNumber;

        children.add(new LabelScore());
        children.add(new LabelQuestion());
        children.add(new LabelGoalGame(stage.stageNumber));
    }

    @Override
    /* The argument is still in pixels */
    public boolean processInput(Vector2f pos) {
        answer = new Coordinate(pos.x, pos.y, true);
        question.answer(answer);
        stage.displayAnswer(this);
        return true;
    }

    @Override
    public void render(Render r) {
    }

    public Question getQuestion() {
        return question;
    }

    public Coordinate getAnswer() {
        return answer;
    }
}
