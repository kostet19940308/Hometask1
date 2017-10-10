package com.example.konstantin.hometask1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import com.example.konstantin.hometask1.fragments.NumberFragments;


public class SecondActivity extends AppCompatActivity {

    private NumberFragments fragment;

    private static final String ACTIVITY_TAG = "Activity";

    public Button b = null;
    public TextView t = null;


    public void stopTimer() {
        Log.d(ACTIVITY_TAG,"stop_timer");
        fragment.stopTimer();
        b.setText(R.string.start_timer_btn);
    }

    public void startTimer() {
        Log.d(ACTIVITY_TAG,"start_timer");
        fragment.startTimer();
        b.setText(R.string.stop_timer_btn);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b = (Button) findViewById(R.id.start_stop);
        b.setText(R.string.start_timer_btn);
        t = (TextView) findViewById(R.id.text_number);

        Log.d(ACTIVITY_TAG, "onCreate");

        if (savedInstanceState == null) {
            fragment = new NumberFragments();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.second_activity, fragment, NumberFragments.TAG)
                    .commit();
            Log.d(ACTIVITY_TAG, "Create fragment");

        } else {
            fragment = (NumberFragments) getSupportFragmentManager().findFragmentByTag(NumberFragments.TAG);
            Log.d(ACTIVITY_TAG, "Update fragment");
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fragment.countdown) {
                    startTimer();
                } else {
                    stopTimer();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d(ACTIVITY_TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

