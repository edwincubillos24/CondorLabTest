package com.edwinacubillos.condorlabtest.splash.business;

import android.content.Intent;

import com.edwinacubillos.condorlabtest.main.view.MainActivity;
import com.edwinacubillos.condorlabtest.splash.presenter.ISplashPresenter;
import com.edwinacubillos.condorlabtest.splash.view.SplashActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashBusiness implements ISplashBusiness {

    ISplashPresenter iSplashPresenter;

    public SplashBusiness(ISplashPresenter iSplashPresenter) {
        this.iSplashPresenter = iSplashPresenter;
    }

    @Override
    public void initTimer(SplashActivity splashActivity) {
        int SPLASH_DELAY = 2000;

        final Intent intent = new Intent(splashActivity, MainActivity.class);

        TimerTask task = new TimerTask(){

            @Override
            public void run() {
                iSplashPresenter.goToMainActivity(intent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_DELAY);

    }
}
