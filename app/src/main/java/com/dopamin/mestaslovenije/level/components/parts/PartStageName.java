package com.dopamin.mestaslovenije.level.components.parts;

import android.graphics.Paint;

import com.dopamin.mestaslovenije.graphics.Render;
import com.dopamin.mestaslovenije.level.components.Stage;
import com.dopamin.mestaslovenije.level.ui.LabelStageName;
import com.dopamin.mestaslovenije.math.Vector2f;
import com.dopamin.mestaslovenije.math.timing.Action;
import com.dopamin.mestaslovenije.math.timing.TimerLimit;


public class PartStageName extends Part {

    public PartStageName(Stage s) {
        super(s);

        timers.add(new TimerLimit(3f, new Action() {
            @Override
            public void execute() {
                stage.nextQuestion();
            }
        }));

        children.add(new LabelStageName());
    }

    @Override
    public boolean processInput(Vector2f pos) {
        return true;
    }

    @Override
    public void render(Render r) {
    }

}
