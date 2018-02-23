package com.dopamin.mestaslovenije.input;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
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

    /**
     * Returns an arraylist of Locations. Sorted by number of times asked ASC.
     * */
    public static ArrayList<Location> loadStageLocations(int stageId){
        String[] projection = {
                DatabaseSchema.Location._ID,
                DatabaseSchema.Location.COLUMN_NAME,
                DatabaseSchema.Location.COLUMN_N,
                DatabaseSchema.Location.COLUMN_E,
                DatabaseSchema.Location.COLUMN_COUNT
        };

        String selection = DatabaseSchema.Location.COLUMN_STAGE_ID + " = ?";
        String[] selectionArgs = { stageId+"" };

        String sortOrder = DatabaseSchema.Location.COLUMN_COUNT+ " ASC";

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

       // Log.e("ENTRY loading now !!", ""  + stageId);
        do{
            Log.e("ENTRY !!", cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_N))
                    + " " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_E))
                    + "\t\t " + cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_COUNT)));

            int id = cursor.getInt(cursor.getColumnIndex(DatabaseSchema.Location._ID));
            float n = cursor.getFloat(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_N));
            float e = cursor.getFloat(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_E));
            Coordinate c = new Coordinate(n, e);
            int count  = cursor.getInt(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_COUNT));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_NAME));

            toReturn.add(new Location(id, name, c, count));
        }while(cursor.moveToNext());

        return toReturn;
    }

    public static String getStageName(int stageId){
        String[] projection = {
                DatabaseSchema.Stage._ID,
                DatabaseSchema.Stage.COLUMN_NAME,
                DatabaseSchema.Stage.COLUMN_ID
        };

        String selection = DatabaseSchema.Stage.COLUMN_ID + " = ?";
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

    public static void increateLocationCount(int questionId){
        ContentValues values = new ContentValues();
        values.put(DatabaseSchema.Location.COLUMN_COUNT, getCount(questionId)+1);
        database.update(DatabaseSchema.Location.TABLE_NAME, values, DatabaseSchema.Score._ID + "="+questionId, null);
    }

    public static int getCount(int questionId){
        String[] projection = {
                DatabaseSchema.Location.COLUMN_COUNT,
        };

        String selection = DatabaseSchema.Location._ID + " = ?";;
        String[] selectionArgs = {questionId+""};

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

        if(cursor.moveToFirst())
            return cursor.getInt(cursor.getColumnIndex(DatabaseSchema.Location.COLUMN_COUNT));
        else
            return -1;
    }

    public static void postNewScore(int score){
        // Insert the new score
        ContentValues valuesStage = new ContentValues();
        valuesStage.put(DatabaseSchema.Score.COLUMN_SCORE, score);
        database.insert(DatabaseSchema.Score.TABLE_NAME, null, valuesStage);
    }

    public static int getBestScore(){
        String[] projection = {
                DatabaseSchema.Score.COLUMN_SCORE,
        };

        String selection = null;
        String[] selectionArgs = {};

        String sortOrder = DatabaseSchema.Score.COLUMN_SCORE + " ASC";

        Cursor cursor = database.query(
                DatabaseSchema.Score.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        if(cursor.moveToFirst())
            return cursor.getInt(cursor.getColumnIndex(DatabaseSchema.Score.COLUMN_SCORE));
        else
            return -1;
    }
}
