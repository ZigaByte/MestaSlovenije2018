package com.dopamin.mestaslovenije.math.timing;

public class Timer {

    public float time = 0;
    public boolean finished = false;

    public Timer() {
    }

    public void update(float deltaTime) {
        time += deltaTime;
    }

    public void reset() {
        finished = false;
        time = 0;
    }

}
