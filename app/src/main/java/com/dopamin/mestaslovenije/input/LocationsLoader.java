package com.dopamin.mestaslovenije.input;

import android.content.Context;
import android.content.res.AssetManager;

import com.dopamin.mestaslovenije.level.components.Location;
import com.dopamin.mestaslovenije.math.Coordinate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.attr.id;

public class LocationsLoader {

    public static AssetManager am = null;

    public static ArrayList<Location> load(String fileName) {

        try {
            InputStream is = am.open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            ArrayList<Location> locations = new ArrayList<Location>();

            String s;
            while ((s = br.readLine()) != null) {
                String[] parts = s.split(",");
                if(parts.length < 5) continue;
                //int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int population = Integer.parseInt(parts[2].trim());
                float n = Float.parseFloat(parts[3].trim());
                float e = Float.parseFloat(parts[4].trim());
                Coordinate coordinate = new Coordinate(n, e);

                locations.add(new Location(0, name, coordinate));
            }

            return locations;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
