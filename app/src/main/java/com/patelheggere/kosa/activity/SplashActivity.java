package com.patelheggere.kosa.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;

import com.patelheggere.kosa.R;
import com.patelheggere.kosa.activity.welcome.WelcomeActivity;
import com.patelheggere.kosa.base.BaseActivity;
import com.patelheggere.kosa.helper.SharedPrefsHelper;
import static com.patelheggere.kosa.helper.AppUtils.Constants.FIRST_TIME;
import static com.patelheggere.kosa.helper.AppUtils.Constants.THREE_SECOND;


public class SplashActivity extends BaseActivity {

    @Override
    protected int getContentView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if(SharedPrefsHelper.getInstance().get(FIRST_TIME, true)) {
                    Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                }

                // close this activity
                finish();

            }



        }, THREE_SECOND);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
