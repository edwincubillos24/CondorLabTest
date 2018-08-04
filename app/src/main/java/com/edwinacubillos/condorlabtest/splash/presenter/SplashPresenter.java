package com.edwinacubillos.condorlabtest.splash.presenter;

import android.content.Intent;

import com.edwinacubillos.condorlabtest.splash.business.ISplashBusiness;
import com.edwinacubillos.condorlabtest.splash.business.SplashBusiness;
import com.edwinacubillos.condorlabtest.splash.view.ISplashView;
import com.edwinacubillos.condorlabtest.splash.view.SplashActivity;

public class SplashPresenter implements ISplashPresenter {

    ISplashView iSplashView;
    ISplashBusiness iSplashBusiness;


    public SplashPresenter(ISplashView iSplashView) {
        this.iSplashView = iSplashView;
        iSplashBusiness = new SplashBusiness(this);
    }

    @Override
    public void initTimer(SplashActivity splashActivity) {
        iSplashBusiness.initTimer(splashActivity);
    }

    @Override
    public void goToMainActivity(Intent intent) {
        iSplashView.goToMainActivity(intent);
    }
}
