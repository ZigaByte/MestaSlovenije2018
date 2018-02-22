package com.dopamin.mestaslovenije.level.menu.ui;

import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.menu.MenuMain;
import com.dopamin.mestaslovenije.math.Vector2f;

public class ButtonMainMenu extends Button {

	@Override
	protected void initLocation() {
		pos = new Vector2f(1100, 900 - 200);
		size = new Vector2f(500, 100);
	}

	protected void initTexture(){
		texture = SpriteLoader.buttonPlay;
	}

	@Override
	protected void pressed() {
		game.setMenu(new MenuMain());
	}

}
