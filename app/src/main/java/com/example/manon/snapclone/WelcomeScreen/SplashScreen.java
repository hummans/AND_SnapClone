package com.example.manon.snapclone.WelcomeScreen;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.manon.snapclone.AppActivity.LogInSignUpActivity;
import com.example.manon.snapclone.R;

public class SplashScreen extends AppCompatActivity {

    private ImageView logoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        logoView = findViewById(R.id.logo);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        logoView.startAnimation(anim);

        final Intent i = new Intent(getApplicationContext(), LogInSignUpActivity.class);
        final Activity act = this;
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        thread.start();
    }
}
