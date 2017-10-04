package com.example.konstantin.hometask1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        new CountDownTimer(2000, 2000){
//            public void onTick(long millisUntilFinished) {
//
//            }
//            public void onFinish(){
//
//            }
//        }.start();
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);
//    }
}
