package com.example.pbb_mataram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {
ImageView image_splash,image_logo_mtr;
TextView text_splash1, text_splash3,tv1_home,tv2_home;
View view_home;
Animation anim_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        image_splash = (ImageView) findViewById(R.id.image_splash);
        image_logo_mtr = (ImageView) findViewById(R.id.image_logo_mtr);
//        text_splash1 = (TextView) findViewById(R.id.text_splash1);
//        text_splash2 = (ImageView) findViewById(R.id.text_splash2);
        text_splash3 = (TextView) findViewById(R.id.text_splash3);
        tv1_home = (TextView) findViewById(R.id.tv1_home);
        tv2_home = (TextView) findViewById(R.id.tv2_home);
        view_home = (View) findViewById(R.id.view_home);
        anim_splash = AnimationUtils.loadAnimation(this, R.anim.anim_splash);

        image_splash.startAnimation(anim_splash);
        image_logo_mtr.startAnimation(anim_splash);
        tv1_home.startAnimation(anim_splash);
        tv2_home.startAnimation(anim_splash);
        view_home.startAnimation(anim_splash);
        text_splash3.startAnimation(anim_splash);

        Typeface splash1 = Typeface.createFromAsset(getAssets(),"font/home.ttf");
        Typeface splash2 = Typeface.createFromAsset(getAssets(),"font/brilliantly.ttf");
        Typeface splash3 = Typeface.createFromAsset(getAssets(),"font/syke.ttf");
        Typeface MLight = Typeface.createFromAsset(getAssets(), "font/Aquawax-Pro-DemiBold-trial.ttf");

//        text_splash1.setTypeface(splash1);
//        text_splash2.setTypeface(splash2);
        text_splash3.setTypeface(MLight);


        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            }
        };
        thread.start();
    }
}
