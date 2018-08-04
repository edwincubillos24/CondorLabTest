package com.edwinacubillos.condorlabtest.main.view;

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
import android.widget.ProgressBar;

import com.edwinacubillos.condorlabtest.Adapters.MoviesAdapter;
import com.edwinacubillos.condorlabtest.favorites.view.FavoritesActivity;
import com.edwinacubillos.condorlabtest.R;
import com.edwinacubillos.condorlabtest.main.presenter.IMainPresenter;
import com.edwinacubillos.condorlabtest.main.presenter.MainPresenter;
import com.edwinacubillos.condorlabtest.model.Movie;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    IMainPresenter iMainPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelected(true);

        iMainPresenter = new MainPresenter(this);

        iMainPresenter.loadMovies();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void sendData(final ArrayList<Movie> movieList) {
        MoviesAdapter moviesAdapter = new MoviesAdapter(this, movieList);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);
        navigation.setSelectedItemId(R.id.mMovies);

        moviesAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iMainPresenter.dataToSaveLocal(getApplicationContext(), movieList.get(recyclerView.getChildLayoutPosition(v)));
            }
        });
    }

    @Override
    public void openDetail(Intent intent) {
        startActivity(intent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mMovies:
                    return true;
                case R.id.mFavorites:
                    Intent i = new Intent(MainActivity.this, FavoritesActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                    return true;
            }
            return false;
        }
    };


}
