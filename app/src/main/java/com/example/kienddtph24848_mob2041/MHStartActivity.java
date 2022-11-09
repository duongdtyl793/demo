package com.example.kienddtph24848_mob2041;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MHStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhstart);

        ImageView logo = findViewById(R.id.logo);

        Glide.with(this).load(R.mipmap.logo1).into(logo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MHStartActivity.this,LoginActivity.class));
            }
        },3000);
    }
}