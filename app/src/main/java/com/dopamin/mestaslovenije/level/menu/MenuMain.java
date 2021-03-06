package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonPlay;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonTutorial;
import com.dopamin.mestaslovenije.level.menu.ui.LabelMainMenu;
import com.dopamin.mestaslovenije.level.menu.ui.LabelBestScore;

public class MenuMain extends Menu {

	public MenuMain() {

	}

	@Override
	public void addElements() {
		children.add(new Background());
		children.add(new LabelMainMenu());
		children.add(new ButtonPlay());
		children.add(new ButtonTutorial());
		//children.add(new ButtonLeaderboard());
		//children.add(new ButtonAbout());
		children.add(new LabelBestScore());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {
	}
}
