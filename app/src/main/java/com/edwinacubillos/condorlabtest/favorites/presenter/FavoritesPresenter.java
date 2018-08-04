package com.edwinacubillos.condorlabtest.favorites.presenter;

import com.edwinacubillos.condorlabtest.favorites.business.FavoritesBusiness;
import com.edwinacubillos.condorlabtest.favorites.business.IFavoritesBusiness;
import com.edwinacubillos.condorlabtest.favorites.view.FavoritesActivity;
import com.edwinacubillos.condorlabtest.favorites.view.IFavoritesActivity;
import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public class FavoritesPresenter implements IFavoritesPresenter{

    IFavoritesActivity iFavoritesActivity;
    IFavoritesBusiness iFavoritesBusiness;

    public FavoritesPresenter(FavoritesActivity favoritesActivity) {
        this.iFavoritesActivity=favoritesActivity;
        iFavoritesBusiness = new FavoritesBusiness(this);
    }

    @Override
    public void loadFavorites() {
        iFavoritesBusiness.loadFavorites();
    }

    @Override
    public void sendData(ArrayList<Movie> movieList) {
        iFavoritesActivity.sendData(movieList);
    }

    @Override
    public void EmptyFavorites() {
        iFavoritesActivity.emptyFavorites();

    }
}
