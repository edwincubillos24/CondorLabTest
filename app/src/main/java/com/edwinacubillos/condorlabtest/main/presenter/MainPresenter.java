package com.edwinacubillos.condorlabtest.main.presenter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.edwinacubillos.condorlabtest.main.business.IMainBusiness;
import com.edwinacubillos.condorlabtest.main.business.MainBusiness;
import com.edwinacubillos.condorlabtest.main.view.IMainActivity;
import com.edwinacubillos.condorlabtest.main.view.MainActivity;
import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

public class MainPresenter implements IMainPresenter {

    IMainActivity iMainActivity;
    IMainBusiness iMainBusiness;

    public MainPresenter(MainActivity mainActivity) {
        this.iMainActivity = mainActivity;
        iMainBusiness = new MainBusiness(this);
    }

    @Override
    public void loadMovies() {
        iMainBusiness.loadMovies();
        iMainActivity.showProgressBar();
    }

    @Override
    public void sendData(ArrayList<Movie> movieList) {
        iMainActivity.hideProgressBar();
        iMainActivity.sendData(movieList);
    }

    @Override
    public void dataToSaveLocal(Context context, Movie movie) {
        iMainBusiness.dataToSaveLocal(context, movie);
    }

    @Override
    public void openDetail(Intent intent) {
        iMainActivity.openDetail(intent);
    }


}
