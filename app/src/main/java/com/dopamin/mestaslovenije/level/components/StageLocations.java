package com.dopamin.mestaslovenije.level.components;

import com.dopamin.mestaslovenije.input.DatabaseLoader;
import com.dopamin.mestaslovenije.input.LocationsLoader;

import java.util.ArrayList;
import java.util.Random;

public class StageLocations {

	public String name;

	public ArrayList<Location> allLocations;

	private StageLocations(){}

	public static StageLocations create(int id){
		StageLocations newStageLocations = new StageLocations();

		newStageLocations.allLocations = DatabaseLoader.loadStageLocations(id);
		newStageLocations.name = DatabaseLoader.getStageName(id);

		return newStageLocations;
	}

	public ArrayList<Question> generate(int questionsPerStage) {
		ArrayList<Location> locations = new ArrayList<Location>();

		// Make sure not too many questions are requested
		if (questionsPerStage >= allLocations.size()) {
			System.out.println("Too many questions requested!!");
		}

		Random random = new Random();

		// Get the number of times the least asked question was asked.
		int minCount = allLocations.get(0).count;
		int attempts = 0;

		// Select questions in a random order until either enough were chosen or
		// all were chosen
		while (locations.size() < questionsPerStage && locations.size() < allLocations.size()) {
			Location l = allLocations.get(random.nextInt(allLocations.size()));

			if (!locations.contains(l) && (minCount + 1 >= l.count || attempts++ > 7))
				locations.add(l);
		}

		// Return this array of empty questions
		ArrayList<Question> questions = new ArrayList<Question>();
		for (Location l : locations) {
			questions.add(new Question(l));
		}

		return questions;
	}

}
