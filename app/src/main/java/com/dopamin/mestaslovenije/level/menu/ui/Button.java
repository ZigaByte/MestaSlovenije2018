package com.dopamin.mestaslovenije.level.menu.ui;


import com.dopamin.mestaslovenije.level.ui.Label;
import com.dopamin.mestaslovenije.math.Vector2f;

public abstract class Button extends Label {

	protected abstract void pressed();

	@Override
	public boolean processInput(Vector2f input) {
		if (!active)
			return false;

		// If the button was pressed, process and return true, else return
		// false. Consider the button a rectangle

		if (input.x >= pos.x && input.y > pos.y && input.x < pos.x + size.x && input.y < pos.y + size.y) {
			pressed();
			return true;
		} else
			return false;
	}
}
