package com.edwinacubillos.condorlabtest.favorites.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.edwinacubillos.condorlabtest.CondorLabTest;
import com.edwinacubillos.condorlabtest.persistence.MovieDBHelper;
import com.edwinacubillos.condorlabtest.favorites.business.FavoritesBusiness;
import com.edwinacubillos.condorlabtest.favorites.business.IFavoritesBusiness;

public class FavoritesRepository implements IFavoritesRepository {

    IFavoritesBusiness iFavoritesBusiness;

    public FavoritesRepository(FavoritesBusiness favoritesBusiness) {
        this.iFavoritesBusiness = favoritesBusiness;
    }

    @Override
    public void loadFavorites() {
        MovieDBHelper movieDBHelper = new MovieDBHelper(CondorLabTest.getAppContext(), "MovieDB", null, 1);
        SQLiteDatabase dbMovie = movieDBHelper.getWritableDatabase();

        Cursor cursor = dbMovie.rawQuery("SELECT * FROM movie WHERE favorite='true'", null);
        iFavoritesBusiness.sendData(cursor);
        dbMovie.close();
    }

}
