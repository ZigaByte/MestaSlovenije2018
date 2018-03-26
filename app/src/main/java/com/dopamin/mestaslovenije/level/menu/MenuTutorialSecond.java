package com.dopamin.mestaslovenije.level.menu;

import android.graphics.Bitmap;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.menu.ui.AnswerArrowTutorial;
import com.dopamin.mestaslovenije.level.menu.ui.QuestionArrowTutorial;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class MenuTutorialSecond extends Menu {

    private Question question;
    Bitmap textureCorrect;
    Bitmap textureAnswer;

    public MenuTutorialSecond(Question question){
        this.question = question;

        textureAnswer = SpriteLoader.gameAnswer;
        textureCorrect = SpriteLoader.gameCorrect;

        // This element is data dependent. So this constructor has to run first
        children.add(new LabelQuestion(question.location.name));
        children.add(new AnswerArrowTutorial());
        children.add(new QuestionArrowTutorial());
    }

    @Override
    public void addElements() {
        children.add(new Background());
    }

    @Override
    public boolean processInput(Vector2f input) {
        game.setMenu(new MenuTutorialThird(question));
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {
    }

    public void renderPostChildren(Render r){
        // Nariši črto in waypointa
        Coordinate answer = question.answer;
        Coordinate correct = question.location.coordinate;
        r.drawLine("#ffffff", correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
        int sizeX = 42, sizeY = 63;
        if(answer.IMAGE_Y > correct.IMAGE_Y){
            r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
            r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
        }else{
            r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
            r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
        }
        r.drawText( question.score + " km", "#FFFFFF", correct.IMAGE_X, correct.IMAGE_Y - sizeY, 5000, -1, 30);

    }
}
