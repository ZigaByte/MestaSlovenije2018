package com.dopamin.mestaslovenije.level.components;

import com.dopamin.mestaslovenije.input.LocationsLoader;

import java.util.ArrayList;
import java.util.Random;

public class StageLocations {

	public static StageLocations testStage = new StageLocations("Test Stage", "coordinates.txt");
	public static StageLocations mesta1 = new StageLocations("Vecja mesta ", "mesta1.txt");
	public static StageLocations mesta2 = new StageLocations("Mesta", "mesta2.txt");
	public static StageLocations mesta3 = new StageLocations("Manjsa mesta", "mesta3.txt");
	public static StageLocations mesta4 = new StageLocations("Manjsa mesta drugic", "mesta4.txt");

	public final String name;

	public final ArrayList<Location> allLocations;

	public StageLocations(String name, String fileName) {
		this.name = name;
		allLocations = LocationsLoader.load(fileName);
	}

	public ArrayList<Question> generate(int questionsPerStage) {
		ArrayList<Location> locations = new ArrayList<Location>();

		// Make sure not too many questions are requested
		if (questionsPerStage >= allLocations.size()) {
			System.out.println("Too many questions requested!!");
		}

		Random random = new Random();

		// Select questions in a random order until either enough were chosen or
		// all were chosen
		while (locations.size() < questionsPerStage && locations.size() < allLocations.size()) {
			Location l = allLocations.get(random.nextInt(allLocations.size()));

			if (!locations.contains(l))
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
