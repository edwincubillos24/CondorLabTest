package com.edwinacubillos.condorlabtest.main.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public interface IMainPresenter {

    void loadMovies();

    void sendData(ArrayList<Movie> movieList);

    void dataToSaveLocal(Context context, Movie movie);

    void openDetail(Intent intent);
}
