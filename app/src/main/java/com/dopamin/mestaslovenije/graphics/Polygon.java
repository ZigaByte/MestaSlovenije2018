package com.dopamin.mestaslovenije.graphics;

import com.dopamin.mestaslovenije.math.Vector2f;

public class Polygon {

    public Vector2f[] VERTICES;
    public int VERTICES_COUNT;

    public Polygon(Vector2f[] verts) {
        VERTICES = verts;
        VERTICES_COUNT = verts.length;
    }

    public Polygon(int verts) {
        this(verts, 1);
    }

    public Polygon(int verts, float size) {
        // /generate the polygon coorinates
        Vector2f[] v = new Vector2f[verts];
        for (int i = 0; i < verts; i++) {
            float angle = ((2 * 3.1416f) / verts) * i;
            v[i] = new Vector2f((float) Math.cos(angle) * size, (float) Math.sin(angle) * size);
        }

        VERTICES = v;
        VERTICES_COUNT = verts;
    }
}
