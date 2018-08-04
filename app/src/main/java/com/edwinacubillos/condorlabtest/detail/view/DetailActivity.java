package com.edwinacubillos.condorlabtest.detail.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.edwinacubillos.condorlabtest.R;
import com.edwinacubillos.condorlabtest.Utils;
import com.edwinacubillos.condorlabtest.detail.presenter.DetailPresenter;
import com.edwinacubillos.condorlabtest.detail.presenter.IDetailPresenter;
import com.edwinacubillos.condorlabtest.model.Movie;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements IDetailActivity {

    IDetailPresenter iDetailPresenter;
    @BindView(R.id.iPicture)
    ImageView iPicture;
    @BindView(R.id.tTitle)
    TextView tTitle;
    @BindView(R.id.tOverview)
    TextView tOverview;
    @BindView(R.id.tReleaseDate)
    TextView tReleaseDate;
    @BindView(R.id.tVideo)
    TextView tVideo;
    @BindView(R.id.bFavorite)
    ImageButton bFavorite;
    @BindView(R.id.tVoteAverage)
    TextView tVoteAverage;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        iDetailPresenter = new DetailPresenter(this);

        iDetailPresenter.loadData(getIntent().getExtras());
    }

    @Override
    public void showDetail(Movie movie) {
        this.movie = movie;
        tTitle.setText(movie.getTitle());
        tOverview.setText("Overview: " + movie.getOverview());
        tReleaseDate.setText(movie.getRelease_date());
        Picasso.get().
                load(Utils.URL_IMAGES + movie.getPoster_path()).
                error(R.drawable.logo).
                into(iPicture);
        tVoteAverage.setText("Vote average: " + movie.getVote_average());
        if (movie.isVideo())
            tVideo.setText("Video: " + movie.getVideo_path());
        else
            tVideo.setText("Video: No Disponible");
        setFavorite();
    }

    @Override
    public void favoriteUpdated(Movie movie) {
        setFavorite();
    }

    @OnClick(R.id.bFavorite)
    public void onViewClicked() {
        iDetailPresenter.updateFavorites(movie);

    }

    private void setFavorite() {
        Log.d("movieFavorite?",String.valueOf(movie.isFavorite()));
        if (movie.isFavorite())
            bFavorite.setImageDrawable(getResources().getDrawable(android.R.drawable.star_big_on));
        else
            bFavorite.setImageDrawable(getResources().getDrawable(android.R.drawable.star_big_off));
    }
}
