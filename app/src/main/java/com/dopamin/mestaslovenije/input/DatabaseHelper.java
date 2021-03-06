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

    public static final int DATABASE_VERSION = 8;
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
        db.execSQL(DatabaseSchema.Score.SQL_CREATE_SCORES);

        // Fill the database. Locations first
        loadStage(db, "mesta1.txt", 0, "Večja mesta");
        loadStage(db, "mesta2.txt", 1, "Srednja mesta");
        loadStage(db, "gore.txt", 2, "Gore");
        loadStage(db, "elektrarne.txt", 3, "Elektrarne");
        loadStage(db, "mesta3.txt", 4, "Manjša mesta");
        loadStage(db, "mesta4.txt", 5, "Majhna mesta");
        loadStage(db, "znamenitosti.txt", 6, "Znamenitosti");
        loadStage(db, "smucisca.txt", 7, "Smučišča");
        loadStage(db, "stadioni.txt", 8, "Stadioni");
        loadStage(db, "naravne_znamenitosti.txt", 9, "Naravne znamenitosti");
        loadStage(db, "podjetja.txt", 10, "Podjetja");
        loadStage(db, "zdravilisca.txt", 11, "Zdravilišča");
        loadStage(db, "gradovi.txt", 12, "Gradovi");
        loadStage(db, "izviri.txt", 13, "Izviri");
        loadStage(db, "muzeji.txt", 14, "Muzeji");
    }

    // Called from onCreate for every stage
    public void loadStage(SQLiteDatabase db, String file, int stage_id, String stageName){
        // Insert the Stage
        ContentValues valuesStage = new ContentValues();
        valuesStage.put(DatabaseSchema.Stage.COLUMN_NAME, stageName);
        valuesStage.put(DatabaseSchema.Stage.COLUMN_ID, stage_id);
        db.insert(DatabaseSchema.Stage.TABLE_NAME, null, valuesStage);

        // Insert all the locations
        Log.e("Hello", file);
        ArrayList<Location> locations = LocationsLoader.load(file);
        for(Location l : locations){
            //Log.e("INserting into " + stageName, l.name);
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
        db.execSQL(DatabaseSchema.Score.SQL_DELETE_SCORES); // Should probably transfer data
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
