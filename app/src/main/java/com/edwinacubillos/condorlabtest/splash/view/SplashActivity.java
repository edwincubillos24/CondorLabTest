package com.edwinacubillos.condorlabtest.splash.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edwinacubillos.condorlabtest.R;
import com.edwinacubillos.condorlabtest.splash.presenter.ISplashPresenter;
import com.edwinacubillos.condorlabtest.splash.presenter.SplashPresenter;

public class SplashActivity extends AppCompatActivity implements ISplashView {

    ISplashPresenter iSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iSplashPresenter = new SplashPresenter(this);

        iSplashPresenter.initTimer(this);
    }

    @Override
    public void goToMainActivity(Intent intent) {
        startActivity(intent);
        finish();
    }
}
