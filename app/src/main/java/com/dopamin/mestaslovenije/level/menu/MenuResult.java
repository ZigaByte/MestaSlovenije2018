package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonMainMenu;

public class MenuResult extends Menu {

	@Override
	public void addElements() {
		children.add(new ButtonMainMenu());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {

	}

}
