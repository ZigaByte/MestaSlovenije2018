package com.dopamin.mestaslovenije.level.menu;


import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.ui.LabelGameWon;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Ziga on 14-Feb-18.
 */

public class MenuGameOver extends MenuResult {

    public MenuGameOver(int score, ArrayList<Question> questions){
        super(score, questions);
    }

    @Override
    public void addElements() {
        super.addElements();
        children.add(new LabelGameWon(false));
    }
}
