package com.dopamin.mestaslovenije.level.components.parts;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.ui.LabelGoal;
import com.dopamin.mestaslovenije.level.ui.LabelStageName;
import com.dopamin.mestaslovenije.level.ui.LabelStageNumber;
import com.dopamin.mestaslovenije.math.Vector2f;

public class PartStageName extends Part {

    public PartStageName(Stage s) {
        super(s);

        children.add(new LabelStageName(s.name));
        children.add(new LabelGoal(s.stageNumber));
        children.add(new LabelStageNumber(s.stageNumber));
    }

    @Override
    public boolean processInput(Vector2f pos) {
        stage.nextQuestion();
        return true;
    }

    @Override
    public void render(Render r) {
    }

}
