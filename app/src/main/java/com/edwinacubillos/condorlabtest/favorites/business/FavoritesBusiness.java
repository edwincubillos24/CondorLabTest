package com.edwinacubillos.condorlabtest.favorites.business;

import android.database.Cursor;
import android.util.Log;

import com.edwinacubillos.condorlabtest.favorites.presenter.FavoritesPresenter;
import com.edwinacubillos.condorlabtest.favorites.presenter.IFavoritesPresenter;
import com.edwinacubillos.condorlabtest.favorites.repository.FavoritesRepository;
import com.edwinacubillos.condorlabtest.favorites.repository.IFavoritesRepository;
import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public class FavoritesBusiness implements IFavoritesBusiness{

    IFavoritesRepository iFavoritesRepository;
    IFavoritesPresenter iFavoritesPresenter;

    public FavoritesBusiness(FavoritesPresenter favoritesPresenter) {
        this.iFavoritesPresenter = favoritesPresenter;
        iFavoritesRepository = new FavoritesRepository(this);
    }

    @Override
    public void loadFavorites() {
        iFavoritesRepository.loadFavorites();
    }

    @Override
    public void sendData(Cursor cursor) {
        ArrayList<Movie> movieList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Movie movie = new Movie(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        Boolean.valueOf(cursor.getString(7)),
                        Boolean.valueOf(cursor.getString(8)));
                movieList.add(movie);
                Log.d("title:",movie.getTitle());
            } while (cursor.moveToNext());
                iFavoritesPresenter.sendData(movieList);
        } else {
            iFavoritesPresenter.EmptyFavorites();
        }
    }
}
