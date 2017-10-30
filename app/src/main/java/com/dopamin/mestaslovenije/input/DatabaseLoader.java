package com.dopamin.mestaslovenije.input;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.dopamin.mestaslovenije.level.components.Location;
import com.dopamin.mestaslovenije.math.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Žiga on 29. 10. 2017.
 */

public class DatabaseLoader {

    static SQLiteDatabase database;

    public static ArrayList<Location> loadStageLocations(int stageId){
        String[] projection = {
                DatabaseSchema.Location._ID,
                DatabaseSchema.Location.COLUMN_NAME,
                DatabaseSchema.Location.COLUMN_N,
                DatabaseSchema.Location.COLUMN_E
        };

        String selection = DatabaseSchema.Location.COLUMN_STAGE_ID + " = ?";
        String[] selectionArgs = { stageId+"" };

        //String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
        String sortOrder = null;

        Cursor cursor = database.query(
                DatabaseSchema.Location.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        cursor.moveToFirst();

        ArrayList<Location> toReturn = new ArrayList<Location>();

        Log.e("ENTRY loading now !!", ""  + stageId);
        while(cursor.moveToNext()) {
            Log.e("ENTRY !!", cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_N))
                    + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_E)));

            int id = cursor.getInt(cursor.getColumnIndex(DatabaseSchema.Location._ID));
            float n = cursor.getFloat(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_N));
            float e = cursor.getFloat(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_E));
            Coordinate c = new Coordinate(n, e);
            String name = cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_NAME));

            toReturn.add(new Location(id, name, c));
        }

        return toReturn;
    }

    public static String getStageName(int stageId){
        String[] projection = {
                DatabaseSchema.Stage._ID,
                DatabaseSchema.Stage.COLUMN_NAME,
                DatabaseSchema.Stage.COLUMN_ID
        };

        String selection =DatabaseSchema.Stage.COLUMN_ID + " = ?";
        String[] selectionArgs = { stageId+"" };

        //String sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
        String sortOrder = null;

        Cursor cursor = database.query(
                DatabaseSchema.Stage.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        cursor.moveToFirst();

        return cursor.getString(cursor.getColumnIndex(DatabaseSchema.Stage.COLUMN_NAME));
    }

}
