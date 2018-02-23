package com.mhasancse.firstaid;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SlashActivity extends AppCompatActivity {
    Animation uptodown, downtoup;

    TextView appTitle;
    ImageView appLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);

        appTitle = (TextView) findViewById(R.id.appTitleTV);
        appLogo = (ImageView) findViewById(R.id.appLogoIV);


        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);

        appLogo.setAnimation(uptodown);
        appTitle.setAnimation(downtoup);


        new CountDownTimer(2500, 2500) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent i = new Intent(SlashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}
