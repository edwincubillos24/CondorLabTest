package com.edwinacubillos.condorlabtest.main.view;

import android.content.Intent;

import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public interface IMainActivity {
    void showProgressBar();

    void hideProgressBar();

    void sendData(ArrayList<Movie> movieList);

    void openDetail(Intent intent);
}
