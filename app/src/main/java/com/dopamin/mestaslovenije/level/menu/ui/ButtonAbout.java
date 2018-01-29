package com.dopamin.mestaslovenije.level.menu.ui;


import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.math.Vector2f;

public class ButtonAbout extends Button {

	@Override
	protected void pressed() {

	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(872, Render.HEIGHT - 181);
		size = new Vector2f(436, 123);
	}

	protected void initTexture(){
		texture = SpriteLoader.buttonAbout;
	}

}
