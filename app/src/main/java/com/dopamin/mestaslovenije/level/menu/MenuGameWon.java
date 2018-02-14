package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.ui.LabelGameWon;

import java.util.ArrayList;

/**
 * Created by Ziga on 14-Feb-18.
 */

public class MenuGameWon extends MenuResult {

    public MenuGameWon(ArrayList<Question> questions){
        super(questions);
    }

    @Override
    public void addElements() {
        super.addElements();
        children.add(new LabelGameWon(true));
    }
}
