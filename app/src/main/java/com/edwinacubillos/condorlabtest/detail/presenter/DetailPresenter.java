package com.edwinacubillos.condorlabtest.detail.presenter;

import android.os.Bundle;

import com.edwinacubillos.condorlabtest.detail.business.DetailBusiness;
import com.edwinacubillos.condorlabtest.detail.business.IDetailBusiness;
import com.edwinacubillos.condorlabtest.detail.view.DetailActivity;
import com.edwinacubillos.condorlabtest.detail.view.IDetailActivity;
import com.edwinacubillos.condorlabtest.model.Movie;


public class DetailPresenter implements IDetailPresenter {

    IDetailActivity iDetailActivity;
    IDetailBusiness iDetailBusiness;


    public DetailPresenter(DetailActivity detailActivity) {
        this.iDetailActivity = detailActivity;
        iDetailBusiness = new DetailBusiness(this);
    }

    @Override
    public void loadData(Bundle extras) {
        iDetailBusiness.loadData(extras);
    }

    @Override
    public void detailToShow(Movie movie) {
        iDetailActivity.showDetail(movie);
    }

    @Override
    public void updateFavorites(Movie movie) {
        iDetailBusiness.updateFavorites(movie);
    }

    @Override
    public void favoriteUpdated(Movie movie) {
        iDetailActivity.favoriteUpdated(movie);
    }
}
