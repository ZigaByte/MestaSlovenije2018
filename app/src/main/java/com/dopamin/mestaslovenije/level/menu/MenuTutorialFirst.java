package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.components.Location;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.menu.ui.QuestionArrowTutorial;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class MenuTutorialFirst extends Menu {

    private Question question;

    public MenuTutorialFirst(){
        Location maribor = new Location(0, "Maribor", new Coordinate(46.55465, 15.645882));
        question = new Question(maribor);

        // This element is data dependent. So this constructor has to run first
        children.add(new LabelQuestion(question.location.name));
        children.add(new QuestionArrowTutorial());
    }

    @Override
    public void addElements() {
        children.add(new Background());
    }

    @Override
    public boolean processInput(Vector2f input) {
        question.answer(new Coordinate((int) input.x, (int) input.y, true));
        game.setMenu(new MenuTutorialSecond(question));
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {

    }
}
