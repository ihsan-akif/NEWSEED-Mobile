package com.shababit.newseedmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenPage extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.icon);
        title = findViewById(R.id.title);

        image.setAnimation(topAnim);
        title.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenPage.this, MainMenuPage.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
