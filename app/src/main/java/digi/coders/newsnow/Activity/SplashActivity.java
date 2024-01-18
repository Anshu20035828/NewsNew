package digi.coders.newsnow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import digi.coders.newsnow.R;
import digi.coders.newsnow.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
ActivitySplashBinding splashBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(splashBinding.getRoot());

        splashBinding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,SignUpActivity.class));
            }
        });
    }
}