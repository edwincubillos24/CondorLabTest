package com.edwinacubillos.condorlabtest.favorites.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.edwinacubillos.condorlabtest.Adapters.MoviesAdapter;
import com.edwinacubillos.condorlabtest.R;
import com.edwinacubillos.condorlabtest.detail.view.DetailActivity;
import com.edwinacubillos.condorlabtest.favorites.presenter.FavoritesPresenter;
import com.edwinacubillos.condorlabtest.favorites.presenter.IFavoritesPresenter;
import com.edwinacubillos.condorlabtest.main.view.MainActivity;
import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoritesActivity extends AppCompatActivity implements  IFavoritesActivity{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    IFavoritesPresenter iFavoritesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.mFavorites);

        iFavoritesPresenter = new FavoritesPresenter(this);

        iFavoritesPresenter.loadFavorites();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mMovies:
                    Intent i = new Intent(FavoritesActivity.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    return true;
                case R.id.mFavorites:
                    return true;
            }
            return false;
        }
    };

    @Override
    public void sendData(final ArrayList<Movie> movieList) {
        MoviesAdapter moviesAdapter = new MoviesAdapter(FavoritesActivity.this,movieList);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);

        moviesAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritesActivity.this, DetailActivity.class);
                intent.putExtra("id",movieList.get(recyclerView.getChildLayoutPosition(v)).getId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void emptyFavorites() {
        Toast.makeText(this, "No tiene peliculas favoritas", Toast.LENGTH_SHORT).show();
    }
}
