package com.dopamin.mestaslovenije.graphics;

import com.dopamin.mestaslovenije.math.Vector2f;

public class Rhomboid extends Polygon {

    public Rhomboid(float width, float height) {
        super(1);
        VERTICES_COUNT = 4;
        float r = (float) Math.toRadians(57);
        float d = height / (float) Math.tan(r);
        Vector2f verts[] = {new Vector2f(-d / 2, 0),
                new Vector2f(width - d / 2, 0),
                new Vector2f(width + d / 2, height),
                new Vector2f(d / 2, height)};
        VERTICES = verts;
    }

}
