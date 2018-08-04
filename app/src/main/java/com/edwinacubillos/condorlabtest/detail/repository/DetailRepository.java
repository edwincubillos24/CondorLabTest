package com.edwinacubillos.condorlabtest.detail.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.edwinacubillos.condorlabtest.CondorLabTest;
import com.edwinacubillos.condorlabtest.persistence.MovieDBHelper;
import com.edwinacubillos.condorlabtest.detail.business.DetailBusiness;
import com.edwinacubillos.condorlabtest.detail.business.IDetailBusiness;
import com.edwinacubillos.condorlabtest.model.Movie;

public class DetailRepository implements IDetailRepository {

    IDetailBusiness iDetailBusiness;

    public DetailRepository(DetailBusiness detailBusiness) {
        this.iDetailBusiness = detailBusiness;
    }

    @Override
    public void loadData(String id) {
        MovieDBHelper movieDBHelper = new MovieDBHelper(CondorLabTest.getAppContext(), "MovieDB", null, 1);
        SQLiteDatabase dbMovie = movieDBHelper.getWritableDatabase();

        Cursor cursor = dbMovie.rawQuery("SELECT * FROM movie WHERE id='" + id + "'", null);
        if (cursor.moveToFirst()) {
            Movie movie = new Movie(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    Boolean.valueOf(cursor.getString(7)),
                    Boolean.valueOf(cursor.getString(8)));

            iDetailBusiness.detailToShow(movie);
        }

    }

    @Override
    public void updateFavorite(Movie movie) {
        MovieDBHelper movieDBHelper = new MovieDBHelper(CondorLabTest.getAppContext(), "MovieDB", null, 1);
        SQLiteDatabase dbMovie = movieDBHelper.getWritableDatabase();

        ContentValues data = new ContentValues();
        data.put("favorite",String.valueOf(movie.isFavorite()));
        dbMovie.update("movie", data, "id='"+movie.getId()+"'" ,null);
        data.clear();
        dbMovie.close();

        iDetailBusiness.favoriteUpdated(movie);
    }
}
