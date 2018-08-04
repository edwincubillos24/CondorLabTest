package com.edwinacubillos.condorlabtest.favorites.view;

import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public interface IFavoritesActivity {
    void sendData(ArrayList<Movie> movieList);

    void emptyFavorites();
}
