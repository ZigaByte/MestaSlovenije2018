package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.level.Entity;

public abstract class Menu extends Entity {

	public Menu() {
		addElements();
	}

	public abstract void addElements();
}
