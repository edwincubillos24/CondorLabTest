package com.edwinacubillos.condorlabtest.detail.business;

import android.os.Bundle;

import com.edwinacubillos.condorlabtest.model.Movie;

public interface IDetailBusiness {
    void loadData(Bundle extras);

    void detailToShow(Movie movie);

    void updateFavorites(Movie movie);

    void favoriteUpdated(Movie movie);
}
