package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.menu.ui.ScoreArrowTutorial;
import com.dopamin.mestaslovenije.level.ui.LabelGoalGame;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;
import com.dopamin.mestaslovenije.level.ui.LabelScore;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class MenuTutorialThird extends MenuTutorialSecond {

    public MenuTutorialThird(Question question){
        super(question);
        children.add(new LabelQuestion(question.location.name));
        children.add(new LabelGoalGame(0));
        children.add(new LabelScore(question.score));
        children.add(new ScoreArrowTutorial());
    }

    @Override
    public void addElements() {
        children.add(new Background());
    }

    @Override
    public boolean processInput(Vector2f input) {
        game.setMenu(new MenuMain());
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {
        super.render(r);
    }
}
