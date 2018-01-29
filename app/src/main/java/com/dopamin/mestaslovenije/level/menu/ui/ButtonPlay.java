package com.dopamin.mestaslovenije.level.menu.ui;

import android.graphics.Paint;
import android.util.Log;

import com.dopamin.mestaslovenije.graphics.Polygon;
import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.menu.MenuLevel;
import com.dopamin.mestaslovenije.math.Vector2f;

public class ButtonPlay extends Button {

	@Override
	protected void pressed() {
		game.setMenu(new MenuLevel());
	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(437, Render.HEIGHT -321);
		size = new Vector2f(367, 281);
	}

	protected void initTexture(){
		texture = SpriteLoader.buttonPlay;
	}

	@Override
	public void render(Render r) {
		super.render(r);

	}

}
