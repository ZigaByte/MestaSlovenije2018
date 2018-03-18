package com.dopamin.mestaslovenije.input;

import android.provider.BaseColumns;

import static com.dopamin.mestaslovenije.input.DatabaseSchema.Location.COLUMN_COUNT;
import static com.dopamin.mestaslovenije.input.DatabaseSchema.Location.COLUMN_E;
import static com.dopamin.mestaslovenije.input.DatabaseSchema.Location.COLUMN_N;
import static com.dopamin.mestaslovenije.input.DatabaseSchema.Location.COLUMN_STAGE_ID;

/**
 * Created by Žiga on 29. 10. 2017.
 */

public final class DatabaseSchema {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DatabaseSchema() {}

    /* Inner class that defines the table contents */
    public static class Location implements BaseColumns {
        public static final String TABLE_NAME = "location";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_N = "n";
        public static final String COLUMN_E = "e";
        public static final String COLUMN_STAGE_ID = "stage_id";
        public static final String COLUMN_COUNT = "count";

        public static final String SQL_CREATE_LOCATIONS =
                "CREATE TABLE " + Location.TABLE_NAME + " (" +
                        Location._ID + " INTEGER PRIMARY KEY," +
                        Location.COLUMN_NAME + " TEXT," +
                        COLUMN_COUNT + " INT," +
                        COLUMN_N + " REAL," +
                        COLUMN_E + " REAL," +
                        COLUMN_STAGE_ID + " INT)";


        public static final String SQL_DELETE_LOCATIONS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /* Inner class that defines the table contents */
    public static class Stage implements BaseColumns {
        public static final String TABLE_NAME = "stage";
        public static final String COLUMN_ID = "stage_id";
        public static final String COLUMN_NAME = "name";

        public static final String SQL_CREATE_STAGES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_ID + " INT)";


        public static final String SQL_DELETE_STAGES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /* Inner class that defines the table contents */
    public static class Score implements BaseColumns {
        public static final String TABLE_NAME = "score";
        public static final String COLUMN_SCORE = "score";

        public static final String SQL_CREATE_SCORES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_SCORE + " INT)";


        public static final String SQL_DELETE_SCORES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }



}

