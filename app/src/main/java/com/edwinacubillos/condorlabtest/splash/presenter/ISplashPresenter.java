package com.edwinacubillos.condorlabtest.splash.presenter;

import android.content.Intent;

import com.edwinacubillos.condorlabtest.splash.view.SplashActivity;

public interface ISplashPresenter {


    void initTimer(SplashActivity splashActivity);

    void goToMainActivity(Intent intent);
}
