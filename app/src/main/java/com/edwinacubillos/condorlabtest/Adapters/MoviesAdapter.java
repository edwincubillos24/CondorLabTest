package com.edwinacubillos.condorlabtest.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.edwinacubillos.condorlabtest.CondorLabTest;
import com.edwinacubillos.condorlabtest.R;
import com.edwinacubillos.condorlabtest.Utils;
import com.edwinacubillos.condorlabtest.favorites.view.FavoritesActivity;
import com.edwinacubillos.condorlabtest.main.view.MainActivity;
import com.edwinacubillos.condorlabtest.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> implements View.OnClickListener {

    Context context;
    private ArrayList<Movie> movieList;
    private View.OnClickListener listener;

    public MoviesAdapter(MainActivity mainActivity, ArrayList<Movie> movieList) {
        this.movieList = movieList;
        context = mainActivity;
    }


    public MoviesAdapter(FavoritesActivity favoritesActivity, ArrayList<Movie> movieList) {
        this.movieList = movieList;
        context = favoritesActivity;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main_individual, parent, false);

        itemView.setOnClickListener(this);

        MoviesViewHolder moviesViewHolder = new MoviesViewHolder(itemView);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie item = movieList.get(position);
        holder.bindMovie(item,context);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iPicture)
        ImageView iPicture;
        @BindView(R.id.tTitle)
        TextView tTitle;
        @BindView(R.id.tVoteAverage)
        TextView tVoteAverage;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindMovie(Movie movie, Context context){
            tTitle.setText(movie.getTitle());
            tVoteAverage.setText(movie.getVote_average());
            Picasso.get().
                    load(Utils.URL_IMAGES+movie.getPoster_path()).
                    error(R.drawable.logo).
                    into(iPicture);
        }
    }

}
