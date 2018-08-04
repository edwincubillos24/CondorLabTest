package com.edwinacubillos.condorlabtest.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDBHelper extends SQLiteOpenHelper {

    String sqlCreateMovie = "CREATE TABLE movie (" +
            "id                 TEXT PRIMARY KEY, " +
            "poster_path        TEXT, " +
            "title              TEXT," +
            "vote_average       TEXT," +
            "overview           TEXT," +
            "release_date       TEXT," +
            "video_path         TEXT," +
            "video              TEXT," +
            "favorite           TEXT)";

    public MovieDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateMovie);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Vehiculos");
        db.execSQL(sqlCreateMovie);
    }
}
