package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonAbout;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonPlay;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonTutorial;

public class MenuMain extends Menu {

	public MenuMain() {

	}

	@Override
	public void addElements() {
		children.add(new ButtonPlay());
		children.add(new ButtonTutorial());
		children.add(new ButtonAbout());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {
	}
}
