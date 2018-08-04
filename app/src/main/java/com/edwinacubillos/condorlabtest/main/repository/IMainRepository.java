package com.edwinacubillos.condorlabtest.main.repository;

import android.content.Context;

import com.edwinacubillos.condorlabtest.model.Movie;

public interface IMainRepository {
    void loadMovies();

    void dataToSaveLocal(Context context, Movie movie);
}
