package com.edwinacubillos.condorlabtest.favorites.presenter;

import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public interface IFavoritesPresenter {
    void loadFavorites();

    void sendData(ArrayList<Movie> movieList);

    void EmptyFavorites();
}
