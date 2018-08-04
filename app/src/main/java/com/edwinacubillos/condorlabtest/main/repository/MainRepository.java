package com.edwinacubillos.condorlabtest.main.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.edwinacubillos.condorlabtest.CondorLabTest;
import com.edwinacubillos.condorlabtest.Utils;
import com.edwinacubillos.condorlabtest.persistence.MovieDBHelper;
import com.edwinacubillos.condorlabtest.main.business.IMainBusiness;
import com.edwinacubillos.condorlabtest.main.business.MainBusiness;
import com.edwinacubillos.condorlabtest.model.Movie;

public class MainRepository implements IMainRepository {

    IMainBusiness iMainBusiness;

    public MainRepository(MainBusiness mainBusiness) {
        this.iMainBusiness = mainBusiness;
    }

    @Override
    public void loadMovies() {

        RequestQueue queue = Volley.newRequestQueue(CondorLabTest.getAppContext());

        String url = Utils.URL_LOADMOVIES+"popular?api_key="+Utils.API_KEY;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        iMainBusiness.sendData(response);
                       // Log.d("Response is: ", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iMainBusiness.sendError(error);
                Log.d("Error: ", error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    @Override
    public void dataToSaveLocal(Context context, Movie movie) {
        MovieDBHelper movieDBHelper = new MovieDBHelper(CondorLabTest.getAppContext(), "MovieDB",null,1);
        SQLiteDatabase dbMovie = movieDBHelper.getWritableDatabase();

        Cursor cursor = dbMovie.rawQuery("SELECT * FROM movie WHERE id='"+movie.getId()+"'",null);
        if (cursor.moveToFirst()){
        }else {
            ContentValues data = new ContentValues();
            data.put("id", movie.getId());
            data.put("poster_path", movie.getPoster_path());
            data.put("title", movie.getTitle());
            data.put("vote_average", movie.getVote_average());
            data.put("overview", movie.getOverview());
            data.put("release_date", movie.getRelease_date());
            data.put("video_path",(""));
            data.put("video", String.valueOf(movie.isVideo()));
            data.put("favorite","false");

            dbMovie.insert("movie", null, data);
            data.clear();
        }
        dbMovie.close();

        iMainBusiness.dataSaved(context, movie.getId());
    }
}
