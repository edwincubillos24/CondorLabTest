package com.edwinacubillos.condorlabtest.favorites.business;

import android.database.Cursor;

public interface IFavoritesBusiness {
    void loadFavorites();

    void sendData(Cursor cursor);
}
