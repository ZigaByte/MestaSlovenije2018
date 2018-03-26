package com.dopamin.mestaslovenije.level;

import android.util.Log;

import com.dopamin.mestaslovenije.MainActivity;
import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.graphics.SpriteLoader;
import com.dopamin.mestaslovenije.input.DatabaseLoader;
import com.dopamin.mestaslovenije.level.Entity;
import com.dopamin.mestaslovenije.level.components.Question;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.components.StageLocations;
import com.dopamin.mestaslovenije.level.menu.MenuGameOver;
import com.dopamin.mestaslovenije.level.menu.MenuGameWon;
import com.dopamin.mestaslovenije.level.menu.MenuResult;
import com.dopamin.mestaslovenije.math.Vector2f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        /*stages.add(new Stage(this, StageLocations.create(3), 3));
        stages.add(new Stage(this, StageLocations.create(4), 4));
        stages.add(new Stage(this, StageLocations.create(5), 5));
        stages.add(new Stage(this, StageLocations.create(6), 6));
        stages.add(new Stage(this, StageLocations.create(7), 7));
        stages.add(new Stage(this, StageLocations.create(8), 8));
        stages.add(new Stage(this, StageLocations.create(9), 9));
        stages.add(new Stage(this, StageLocations.create(10), 10));
        stages.add(new Stage(this, StageLocations.create(11), 11));
        stages.add(new Stage(this, StageLocations.create(12), 12));
        stages.add(new Stage(this, StageLocations.create(13), 13));
        stages.add(new Stage(this, StageLocations.create(14), 14));*/
    }

    /**
     * Move to next stage. Deactivate current and activate next
     */
    public void nextStage() {
        if (currentStage != null)
            currentStage.setActive(false);

        // Check if we are over with the stages
        if (currentStageNumber < stages.size() - 1) {
            currentStageNumber++;

            children.add(currentStage = stages.get(currentStageNumber));
            currentStage.begin();
        } else {
            // Finish up or something
            endLevel(true);
        }
    }

    public void endLevel(boolean completedAllStages){
        if(completedAllStages){
            game.setMenu(new MenuGameWon((int)getScore(), getX(1, false)));
            //MainActivity.getGame().services.submitScore((long)getScore());
            DatabaseLoader.postNewScore((int)getScore());
        }
        else{
            game.setMenu(new MenuGameOver((int)getScore(), getX(1, true)));
        }
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

    private ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questions = new ArrayList<Question>();
        for(int i = 0; i <= currentStageNumber; i++){
            Stage s = stages.get(i);
            for(int j = 0; j < s.questionsPerStage; j++){
                questions.add(s.getQuestion(j));
            }
        }
        return questions;
    }

    private ArrayList<Question> getX(final int x, final boolean best){
        ArrayList<Question> sorted = getAllQuestions();
        Collections.sort(sorted, new Comparator<Question>(){
            @Override
            public int compare(Question q1, Question q2) {
                return ((q1.score < q2.score) ? 1 : -1 ) * (best ? 1 : - 1);
            }
        });
        ArrayList<Question> limited = new ArrayList<Question>();
        for(int i = 0; i < Math.min(sorted.size(), x); i++){
            limited.add(sorted.get(i));
        }
        return limited;
    }


}
