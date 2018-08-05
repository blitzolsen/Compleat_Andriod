package com.example.stettsen.compleat_andriod;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashPage extends AppCompatActivity {

    private static String FILE = "CookBookDB.json";
    AnimationDrawable loadAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        TextView progressStatus = findViewById(R.id.progressStatus);
        ProgressBar progressBar = findViewById(R.id.splashScreenProgressBar);

        ImageView animationView = (ImageView) findViewById(R.id.loadAnimation);
        animationView.setBackgroundResource(R.drawable.load_image);
        loadAnimation = (AnimationDrawable) animationView.getBackground();
        loadAnimation.start();

        boolean done = false;

        Thread newThread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        newThread.start();
        LoadOnStartAsyncTask task = new LoadOnStartAsyncTask(FILE, progressBar, getApplicationContext(), progressStatus);
        task.execute();
    }
}