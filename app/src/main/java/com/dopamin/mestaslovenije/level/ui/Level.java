package com.dopamin.mestaslovenije.level.ui;

import android.util.Log;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.components.StageLocations;
import com.dopamin.mestaslovenije.level.menu.MenuResult;
import com.dopamin.mestaslovenije.math.Vector2f;

import java.util.ArrayList;

public class Level extends UIElement {

    // ArrayList of all generated stages of the game
    private ArrayList<Stage> stages = new ArrayList<Stage>();

    private Stage currentStage;
    private int currentStageNumber = -1; // nextLevel gets called, so it starts with 0

    public Level() {
        pos = new Vector2f(0, 0);
        size = new Vector2f(Render.WIDTH, Render.HEIGHT);

        generateStages();
        nextStage();
    }

    private void generateStages() {
        stages.add(new Stage(this, StageLocations.create(0), 0));
        stages.add(new Stage(this, StageLocations.create(1), 1));
        stages.add(new Stage(this, StageLocations.create(2), 2));
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
        } else {
            // Finish up or something
            game.setMenu(new MenuResult());

        }
    }

    @Override
    public boolean processInput(Vector2f input) {
        return currentStage.processInput(input);
    }

    @Override
    protected void loadTexture() {
        texture = SpriteLoader.background;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Render r) {
        r.drawTexture(texture, pos.x, pos.y, size.x, size.y);
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
