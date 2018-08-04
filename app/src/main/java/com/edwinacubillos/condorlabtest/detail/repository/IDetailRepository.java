package com.edwinacubillos.condorlabtest.detail.repository;

import com.edwinacubillos.condorlabtest.detail.business.DetailBusiness;
import com.edwinacubillos.condorlabtest.detail.business.IDetailBusiness;
import com.edwinacubillos.condorlabtest.model.Movie;

public interface IDetailRepository {


    void loadData(String id);

    void updateFavorite(Movie movie);
}
