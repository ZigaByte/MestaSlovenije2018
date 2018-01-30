package com.dopamin.mestaslovenije.level.components.parts;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.math.Coordinate;
import com.dopamin.mestaslovenije.math.Vector2f;

public class PartAnswer extends Part {

	Bitmap textureCorrect;
	Bitmap textureAnswer;
	private PartQuestion partQuestion;

	public PartAnswer(Stage stage, PartQuestion partQuestion) {
		super(stage);
		this.partQuestion = partQuestion;
		textureAnswer = SpriteLoader.gameAnswer;
		textureCorrect = SpriteLoader.gameCorrect;
	}

	@Override
	public boolean processInput(Vector2f pos) {
		stage.nextQuestion();
		return true;
	}

	@Override
	public void render(Render r) {
		partQuestion.render(r);

		Coordinate answer = partQuestion.getAnswer();
		Coordinate correct = partQuestion.getQuestion().location.coordinate;
		r.drawLine("#000000", correct.IMAGE_X, correct.IMAGE_Y, answer.IMAGE_X, answer.IMAGE_Y);
		int sizeX = 42, sizeY = 63;
		if(answer.IMAGE_Y > correct.IMAGE_Y){
			r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
			r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
		}else{
			r.drawTexture(textureAnswer, answer.IMAGE_X - sizeX / 2, answer.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
			r.drawTexture(textureCorrect, correct.IMAGE_X - sizeX / 2, correct.IMAGE_Y - (sizeY * 9 / 10) , sizeX, sizeY);
		}
		//r.drawCirlce("#00FF00", correct.IMAGE_X, correct.IMAGE_Y, 10);
		//r.drawCirlce("#FF0000", answer.IMAGE_X, answer.IMAGE_Y, 10);
		//r.drawText((int)(Coordinate.distanceInKilometers(correct, answer) * 10) / 10f + " km","#000000", (correct.IMAGE_X + answer.IMAGE_X) / 2, (correct.IMAGE_Y + answer.IMAGE_Y) / 2 - 10, 25, Paint.Align.CENTER);
	}

}
