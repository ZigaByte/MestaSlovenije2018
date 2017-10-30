package com.dopamin.mestaslovenije.input;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import com.dopamin.mestaslovenije.level.components.Location;

import java.util.ArrayList;

/**
 * Created by Žiga on 29. 10. 2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "Database.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        DatabaseLoader.database = db;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseSchema.Location.SQL_CREATE_LOCATIONS);
        db.execSQL(DatabaseSchema.Stage.SQL_CREATE_STAGES);

        // Fill the database. Locations first
        loadStage(db, "mesta1.txt", 0, "Večja mesta");
        loadStage(db, "mesta2.txt", 1, "Srednja mesta");
        loadStage(db, "mesta3.txt", 2, "Manjša mesta");

    }

    // Called from onCreate for every stage
    public void loadStage(SQLiteDatabase db, String file, int stage_id, String stageName){
        // Insert the Stage
        ContentValues valuesStage = new ContentValues();
        valuesStage.put(DatabaseSchema.Stage.COLUMN_NAME, stageName);
        valuesStage.put(DatabaseSchema.Stage.COLUMN_ID, stage_id);
        db.insert(DatabaseSchema.Stage.TABLE_NAME, null, valuesStage);

        // Insert all the locations
        ArrayList<Location> locations = LocationsLoader.load(file);
        for(Location l : locations){
            ContentValues values = new ContentValues();
            values.put(DatabaseSchema.Location.COLUMN_NAME, l.name);
            values.put(DatabaseSchema.Location.COLUMN_N, l.coordinate.n);
            values.put(DatabaseSchema.Location.COLUMN_E, l.coordinate.e);
            values.put(DatabaseSchema.Location.COLUMN_COUNT, 0);
            values.put(DatabaseSchema.Location.COLUMN_STAGE_ID, stage_id);

            db.insert(DatabaseSchema.Location.TABLE_NAME, null, values);
        }
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatabaseSchema.Location.SQL_DELETE_LOCATIONS);
        db.execSQL(DatabaseSchema.Stage.SQL_DELETE_STAGES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}