package com.dopamin.mestaslovenije.level.components;

import com.dopamin.mestaslovenije.math.Coordinate;

public class Question {

	public Location location;
	public Coordinate answer;

	public int score;

	public Question(Location location) {
		this.location = location;
	}

	public void answer(Coordinate answer) {
		this.answer = answer;

		score = (int)Coordinate.distanceInKilometers(answer, location.coordinate);
		//System.out.printf("Press> %f, %f,  Actual> %f, %f\n", answer.n, answer.e, location.coordinate.n, location.coordinate.e);
		//System.out.println(score);
	}

}
