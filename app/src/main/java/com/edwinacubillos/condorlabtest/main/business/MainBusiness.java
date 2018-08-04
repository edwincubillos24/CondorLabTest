package com.edwinacubillos.condorlabtest.main.business;

import android.content.Context;
import android.content.Intent;

import com.android.volley.VolleyError;
import com.edwinacubillos.condorlabtest.detail.view.DetailActivity;
import com.edwinacubillos.condorlabtest.main.presenter.IMainPresenter;
import com.edwinacubillos.condorlabtest.main.presenter.MainPresenter;
import com.edwinacubillos.condorlabtest.main.repository.IMainRepository;
import com.edwinacubillos.condorlabtest.main.repository.MainRepository;
import com.edwinacubillos.condorlabtest.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainBusiness implements IMainBusiness {

    IMainPresenter iMainPresenter;
    IMainRepository iMainRepository;

    public MainBusiness(MainPresenter mainPresenter) {

        this.iMainPresenter = mainPresenter;
        iMainRepository = new MainRepository(this);
    }

    @Override
    public void loadMovies() {
        iMainRepository.loadMovies();
    }

    @Override
    public void sendData(String response) {

        Type movieListType = new TypeToken<ArrayList<Movie>>(){}.getType();

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            Gson gson = new Gson();
            ArrayList<Movie> movieList = gson.fromJson(String.valueOf(jsonArray),movieListType);
            iMainPresenter.sendData(movieList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendError(VolleyError error) {

    }

    @Override
    public void dataToSaveLocal(Context context, Movie movie) {
        iMainRepository.dataToSaveLocal(context, movie);
    }

    @Override
    public void dataSaved(Context context, String id) {
        Intent intent = new Intent (context, DetailActivity.class);
        intent.putExtra("id",id);
        iMainPresenter.openDetail(intent);

    }
}
