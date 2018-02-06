package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonMainMenu;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;

/**
 * Created by Žiga on 6. 02. 2018.
 */

public class MenuTutorial extends Menu {

    @Override
    public void addElements() {
        children.add(new Background());
        children.add(new LabelQuestion());
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Render r) {

    }
}
