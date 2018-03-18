package com.dopamin.mestaslovenije.level.menu;

import com.dopamin.mestaslovenije.MainActivity;
import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.Level;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.menu.ui.ButtonMainMenu;
import com.dopamin.mestaslovenije.level.ui.LabelGameWon;
import com.dopamin.mestaslovenije.math.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class MenuResult extends Menu {

	private ArrayList<Question> questions;

	public MenuResult(ArrayList<Question> questions){
		this.questions = questions;

		((MainActivity)MainActivity.getGame().context).showAd();
	}

	@Override
	public void addElements() {
		children.add(new Background());
		children.add(new ButtonMainMenu());
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Render r) {
	}

	@Override
	public void renderPostChildren(Render r) {
		super.renderPostChildren(r);

		// Render all the questions. not sure if best idea
		for (Question q : questions) {
			Coordinate answer = q.answer;
			Coordinate correct = q.location.coordinate;

			r.drawLine("#ffffff", correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
		}
		// Draw the points
		int sizeX = 42, sizeY = 63;
		for (Question q : questions) {
			Coordinate answer = q.answer;
			Coordinate correct = q.location.coordinate;
			if (answer.IMAGE_Y > correct.IMAGE_Y) {
				r.drawTexture(SpriteLoader.gameCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
				r.drawTexture(SpriteLoader.gameAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
			} else {
				r.drawTexture(SpriteLoader.gameAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
				r.drawTexture(SpriteLoader.gameCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10), sizeX, sizeY);
			}

		}
		// Draw the distances
		for (Question q : questions) {
			Coordinate answer = q.answer;
			Coordinate correct = q.location.coordinate;
			r.drawText((String.format("%.1f", q.score) + " km").replace('.', ','), "#FFFFFF", correct.IMAGE_X, correct.IMAGE_Y - sizeY, 5000, -1, 30);
		}
	}


}
