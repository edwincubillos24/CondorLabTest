package com.edwinacubillos.condorlabtest.main.business;

import android.content.Context;

import com.android.volley.VolleyError;
import com.edwinacubillos.condorlabtest.model.Movie;

public interface IMainBusiness {
    
    void loadMovies();

    void sendData(String response);

    void sendError(VolleyError error);

    void dataToSaveLocal(Context context, Movie movie);

    void dataSaved(Context context, String id);
}
