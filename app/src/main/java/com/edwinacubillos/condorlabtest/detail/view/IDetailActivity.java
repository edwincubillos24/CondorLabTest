package com.edwinacubillos.condorlabtest.detail.view;

import com.edwinacubillos.condorlabtest.model.Movie;

public interface IDetailActivity {
    void showDetail(Movie movie);

    void favoriteUpdated(Movie movie);
}
