package com.dopamin.mestaslovenije.math;

import com.dopamin.mestaslovenije.graphics.Render;

public class Coordinate {

    static Coordinate fixed1;
    static Coordinate fixed2;

    static {
        fixed1 = new Coordinate(45.528319, 13.568289499999992, 178, 72);
        fixed2 = new Coordinate(46.6560877, 16.0380562, 1249, 759);
    }

    public final int IMAGE_X;
    public final int IMAGE_Y;
    public final double n, e;

    public Coordinate(float x, float y, boolean pixels) {
        if (!pixels)
            System.out.println("CALL THE OTHER METHOD FOOL");

        IMAGE_X = (int) x;
        IMAGE_Y = (int) y;

        double sX = (fixed2.e - fixed1.e) / (fixed2.IMAGE_X - fixed1.IMAGE_X);
        double sY = (fixed2.n - fixed1.n) / (fixed2.IMAGE_Y - fixed1.IMAGE_Y);

        e = (fixed1.e + sX * (x - fixed1.IMAGE_X));
        n = (fixed1.n + sY * ((Render.HEIGHT - y) - fixed1.IMAGE_Y));

    }

    public Coordinate(double n, double e) {
        this.n = n;
        this.e = e;
        double sX = (fixed2.IMAGE_X - fixed1.IMAGE_X) / (fixed2.e - fixed1.e);
        IMAGE_X = (int) (fixed1.IMAGE_X + sX * (e - fixed1.e));

        double sY = (fixed2.IMAGE_Y - fixed1.IMAGE_Y) / (fixed2.n - fixed1.n);
        IMAGE_Y = Render.HEIGHT - (int) (fixed1.IMAGE_Y + sY * (n - fixed1.n));
    }

    public Coordinate(double n, double e, int x, int y) {
        this.n = n;
        this.e = e;
        IMAGE_X = x;
        IMAGE_Y = y;
    }

    /**
     * Calculates the real world distance in kilometres between two coordinate
     * points in the usual GPS style
     */
    public static float distanceInKilometers(Coordinate point1, Coordinate point2) {
        double lat1 = point1.n;
        double lon1 = point1.e;

        double lat2 = point2.n;
        double lon2 = point2.e;

        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);

        int R = 6371000; // metres
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double d = R * c;

        return (float) d / 1000.0f;
    }

}
