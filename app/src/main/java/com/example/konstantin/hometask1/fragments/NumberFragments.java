package com.example.konstantin.hometask1.fragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.konstantin.hometask1.R;
import com.example.konstantin.hometask1.SecondActivity;


public class NumberFragments extends Fragment {
    private static final String FRAGMENT_TAG = "Fragment";

    public static final String TAG = NumberFragments.class.getSimpleName();

    private static final String STATE_NUMBER = "number";
    private static final String COUNTDOWN = "countdown";
    public boolean countdown = false;
    private boolean pause = false;
    public int number = 0;

    CountDownTimer timer;
    private SecondActivity activity;
    private TextView view;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(FRAGMENT_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(STATE_NUMBER);
            countdown = savedInstanceState.getBoolean(COUNTDOWN);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        activity = (SecondActivity) getActivity();
        view = activity.t;
        button = activity.b;
        if (number != 0){
            view.setText(numberToString(number));
        }
        if (countdown)
            button.setText(R.string.stop_timer_btn);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(FRAGMENT_TAG, "onActiviryCreate");
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            number = savedInstanceState.getInt(STATE_NUMBER);
            countdown = savedInstanceState.getBoolean(COUNTDOWN);
        }


        if(countdown){
            Log.d(FRAGMENT_TAG, "countdown");
            timer = new CountDownTimer(1000 * (1000 - number), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    number++;
                    view.setText(numberToString(number));
                }

                @Override
                public void onFinish() {
                    Log.d(FRAGMENT_TAG, "Finish_timer");
                    countdown = false;
                    number = 0;
                    button.setText(R.string.start_timer_btn);
                }
            }.start();
        }
            //startTimer();
    }

    @Override
    public void onPause() {
        Log.d(FRAGMENT_TAG, "onPause");
        super.onPause();
        if (timer != null)
            timer.cancel();
        if (countdown){
            pause = true;
        }

    }

    public void onResume() {
        super.onResume();

        Log.d(FRAGMENT_TAG, "onResume");
        if ((timer == null) && pause) {
            button.setText(R.string.stop_timer_btn);
            timer = new CountDownTimer(1000 * (1000 - number), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    number++;
                    view.setText(numberToString(number));
                }

                @Override
                public void onFinish() {
                    countdown = false;
                    number = 0;
                    button.setText(R.string.start_timer_btn);
                }
            }.start();
        }
    }

    @Override
    public void onDetach() {
        Log.d(FRAGMENT_TAG, "onDetach");
        if(timer != null)
            timer.cancel();
        if (countdown)
            countdown = false;
        pause = false;
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(COUNTDOWN, countdown);
        outState.putInt(STATE_NUMBER, number);
    }

    public void startTimer(){
        Log.d(FRAGMENT_TAG, "start timer");
        if(!countdown){
            countdown = true;
            timer = new CountDownTimer(1000 * (1000 - number), 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //Log.d(FRAGMENT_TAG, Long.toString(millisUntilFinished));
                    number++;
                    view.setText(numberToString(number));
                }

                @Override
                public void onFinish() {
                    countdown = false;
                    number = 0;
                    button.setText(R.string.start_timer_btn);
                }
            }.start();
        }
    }

    public void stopTimer(){
        Log.d(FRAGMENT_TAG, "stop_timer");
        if (timer != null && countdown) {
            countdown = false;
            timer.cancel();
        }
    }


    private String numberToString(int number){
        String strNumber = "";
        int n1, n2, n3;
        if (number >= 1000)
            return "Тысяча";
        n1 = number / 100;
        n2 = number % 100;
        switch (n1){
            case 1:
                strNumber +="Сто ";
                break;
            case 2:
                strNumber +="Двести ";
                break;
            case 3:
                strNumber +="Триста ";
                break;
            case 4:
                strNumber +="Четыреста ";
                break;
            case 5:
                strNumber +="Пятьсот ";
                break;
            case 6:
                strNumber +="Шестьсот ";
                break;
            case 7:
                strNumber +="Семьсот ";
                break;
            case 8:
                strNumber +="Восемьсот ";
                break;
            case 9:
                strNumber +="Девятьсот ";
                break;
            default:
                break;
        }

        if((n2 >= 10) && (n2 < 20)){
            switch (n2) {
                case 10:
                    strNumber += "Десять ";
                    break;
                case 11:
                    strNumber += "Одиннадцать ";
                    break;
                case 12:
                    strNumber += "Двенадцать ";
                    break;
                case 13:
                    strNumber += "Тринадцать ";
                    break;
                case 14:
                    strNumber += "Четырнадцать ";
                    break;
                case 15:
                    strNumber += "Пятнадцать ";
                    break;
                case 16:
                    strNumber += "Шестнадцать ";
                    break;
                case 17:
                    strNumber += "Семнадцать ";
                    break;
                case 18:
                    strNumber += "Восемнадцать ";
                    break;
                case 19:
                    strNumber += "Девятнадцать ";
                    break;
                default:
                    break;
            }
            return strNumber;
        }

        n3 = n2 % 10;
        n2 = n2 / 10;

        switch (n2) {
            case 2:
                strNumber += "Двадцать ";
                break;
            case 3:
                strNumber += "Тридцать ";
                break;
            case 4:
                strNumber += "Сорок ";
                break;
            case 5:
                strNumber += "Пятьдесят ";
                break;
            case 6:
                strNumber += "Шестьдесят ";
                break;
            case 7:
                strNumber += "Семьдесят ";
                break;
            case 8:
                strNumber += "Восемьдесят ";
                break;
            case 9:
                strNumber += "Девяносто ";
                break;
            default:
                break;
        }

        switch (n3) {
            case 1:
                strNumber += "Один";
                break;
            case 2:
                strNumber += "Два";
                break;
            case 3:
                strNumber += "Три";
                break;
            case 4:
                strNumber += "Четыре";
                break;
            case 5:
                strNumber += "Пять";
                break;
            case 6:
                strNumber += "Шесть";
                break;
            case 7:
                strNumber += "Семь";
                break;
            case 8:
                strNumber += "Восемь";
                break;
            case 9:
                strNumber += "Девять";
                break;
            default:
                break;
        }

        return strNumber;
    }


}
