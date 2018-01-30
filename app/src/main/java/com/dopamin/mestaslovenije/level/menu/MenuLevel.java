package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.level.ui.LabelQuestion;
import com.dopamin.mestaslovenije.level.ui.LabelScore;
import com.dopamin.mestaslovenije.level.Level;

public class MenuLevel extends Menu {

	@Override
	public void addElements() {
		children.add(new Background());

		children.add(new Level());
		children.add(new LabelScore());
		children.add(new LabelQuestion());
	}

	@Override
	public void update() {
	}

	@Override
	public void render(Render r) {
	}

	public Level getLevel() {
		// Do not change the order of adding them or this will break :D
		for(Entity e: children)
			if(e instanceof  Level)
				return (Level)e;
		return null;
	}

}
