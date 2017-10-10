package com.example.konstantin.hometask1;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StartActivity extends AppCompatActivity {

    private static final String ACTIVITY_TAG = "Start";

    CountDownTimer timer = null;


    private long timeBeforeKill = 2000;
    private static final long STEP = 100;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(ACTIVITY_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Intent intent = new Intent(this, SecondActivity.class);

        timer = new CountDownTimer(timeBeforeKill - count * STEP, STEP){
            public void onTick(long millisUntilFinished) {
                count++;
            }
            public void onFinish(){
                startActivity(intent);
                timeBeforeKill = 0;
            }
        }.start();
    }


    @Override
    protected void onPause() {
        Log.d(ACTIVITY_TAG, "onPause");
        super.onPause();
        if(timeBeforeKill == 0) {
            Log.d(ACTIVITY_TAG, "killActivity");
            timer.cancel();
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        Log.d(ACTIVITY_TAG, "onDestroy");
        timer.cancel();
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("time");
        Log.d(ACTIVITY_TAG, Integer.toString(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("time", count);
        super.onSaveInstanceState(outState);
    }

    protected void onStop(){
        super.onStop();
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
