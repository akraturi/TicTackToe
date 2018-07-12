package com.example.amit.connect3game;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FlashActivity extends AppCompatActivity {

    private static int SPLASH_TIMEOUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(FlashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMEOUT);


    }
}
