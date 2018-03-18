package com.dopamin.mestaslovenije.level.ui;

import com.dopamin.mestaslovenije.input.DatabaseLoader;

/**
 * Created by Ziga on 23-Feb-18.
 */

public class LabelBestScore extends LabelScore {

    public LabelBestScore(){
        super(DatabaseLoader.getBestScore());
    }

    @Override
    protected void initLocation() {
        super.initLocation();
        pos = pos.add(-243, -60);
    }
}
