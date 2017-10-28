package com.dopamin.mestaslovenije.level.menu.ui;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.menu.MenuLevel;
import com.dopamin.mestaslovenije.math.Vector2f;

public class ButtonPlay extends Button {

	@Override
	protected void pressed() {
		game.setMenu(new MenuLevel());
	}

	@Override
	protected void initLocation() {
		pos = new Vector2f(50, 900 - 150);
		size = new Vector2f(500, 100);
	}

	@Override
	public void render(Render r) {
		super.render(r);
		r.drawText("IGRAJ", "#000000", pos.x + size.x / 2, pos.y + size.y * 3 / 4, 64, Paint.Align.CENTER);

	}

}
