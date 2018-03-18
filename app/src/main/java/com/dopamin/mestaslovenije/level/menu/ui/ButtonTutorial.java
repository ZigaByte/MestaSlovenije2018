package com.dopamin.mestaslovenije.level.menu.ui;


import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.menu.MenuTutorialFirst;
import com.dopamin.mestaslovenije.math.Vector2f;

public class ButtonTutorial extends Button {

	@Override
	protected void pressed() {
		game.setMenu(new MenuTutorialFirst());
	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(852, Render.HEIGHT -390);
		size = new Vector2f(436, 123);
	}

	protected void initTexture(){
		texture = SpriteLoader.buttonInstructions;
	}

}
