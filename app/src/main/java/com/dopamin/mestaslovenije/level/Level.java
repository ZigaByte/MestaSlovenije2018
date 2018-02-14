package com.dopamin.mestaslovenije.level;

import android.util.Log;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.components.StageLocations;
import com.dopamin.mestaslovenije.level.menu.MenuResult;
import com.dopamin.mestaslovenije.math.Vector2f;

import java.util.ArrayList;

public class Level extends Entity{

    // ArrayList of all generated stages of the game
    private ArrayList<Stage> stages = new ArrayList<Stage>();

    private Stage currentStage;
    private int currentStageNumber = -1; // nextLevel gets called, so it starts with 0

    public Level() {
        generateStages();
        nextStage();
    }

    private void generateStages() {
        stages.add(new Stage(this, StageLocations.create(0), 0));
        stages.add(new Stage(this, StageLocations.create(1), 1));
        stages.add(new Stage(this, StageLocations.create(2), 2));
        stages.add(new Stage(this, StageLocations.create(3), 3));
        stages.add(new Stage(this, StageLocations.create(4), 4));
        stages.add(new Stage(this, StageLocations.create(5), 5));
        stages.add(new Stage(this, StageLocations.create(6), 6));
        stages.add(new Stage(this, StageLocations.create(7), 7));

    }

    /**
     * Move to next stage. Deactivate current and activate next
     */
    public void nextStage() {
        if (currentStage != null)
            currentStage.setActive(false);

        currentStageNumber++;

        // Check if we are over with the stages
        if (currentStageNumber < stages.size()) {
            children.add(currentStage = stages.get(currentStageNumber));
            currentStage.begin();
        } else {
            // Finish up or something
            endLevel(true);
        }
    }

    public void endLevel(boolean completedAllStages){
        game.setMenu(new MenuResult());
    }

    @Override
    public boolean processInput(Vector2f input) {
        return currentStage.processInput(input);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Render r) {
    }

    /**
     * Adds up all the scores from all the stages
     */
    public float getScore() {
        float score = 0;
        for (Stage s : stages) {
            score += s.getScore();
        }
        return score;
    }

}
