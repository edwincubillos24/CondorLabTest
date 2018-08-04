package com.edwinacubillos.condorlabtest.detail.business;

import android.os.Bundle;
import android.util.Log;

import com.edwinacubillos.condorlabtest.detail.presenter.DetailPresenter;
import com.edwinacubillos.condorlabtest.detail.presenter.IDetailPresenter;
import com.edwinacubillos.condorlabtest.detail.repository.DetailRepository;
import com.edwinacubillos.condorlabtest.detail.repository.IDetailRepository;
import com.edwinacubillos.condorlabtest.model.Movie;

public class DetailBusiness implements IDetailBusiness{

    IDetailPresenter iDetailPresenter;
    IDetailRepository iDetailRepository;

    public DetailBusiness(DetailPresenter detailPresenter) {
        this.iDetailPresenter = detailPresenter;
        iDetailRepository = new DetailRepository(this);
    }

    @Override
    public void loadData(Bundle extras) {
        String id = extras.getString("id","0");
        Log.d("id",id);

        iDetailRepository.loadData(id);

    }

    @Override
    public void detailToShow(Movie movie) {
        iDetailPresenter.detailToShow(movie);
    }

    @Override
    public void updateFavorites(Movie movie) {
        if (movie.isFavorite())
            movie.setFavorite(false);
        else
            movie.setFavorite(true);
        iDetailRepository.updateFavorite(movie);
    }

    @Override
    public void favoriteUpdated(Movie movie) {
        iDetailPresenter.favoriteUpdated(movie);
    }
}
