package com.example.slotmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GridLayout grid;
    private Drawable apple;
    private Drawable cherry;
    private Drawable pear;
    public TextView score;
    public SeekBar speed;
    public Button stop;
    public Button start;
    private ImageView[] imageViews;
    private Random rand;
    public int count;
    public Handler handler;
    private int fruitLocation;
    private UpdateOne updateOne;
    private UpdateTwo updateTwo;
    private UpdateThree updateThree;
    private int speedNum;
    private int speedNumTwo;
    private int speedNumThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.gridLayout);
        apple = getDrawable(R.drawable.apple);
        cherry = getDrawable(R.drawable.cherry);
        pear = getDrawable(R.drawable.pear);
        score = findViewById(R.id.score);
        speed = findViewById(R.id.speedBar);
        stop = findViewById(R.id.stop);
        start = findViewById(R.id.start);
        imageViews = new ImageView[3];
        rand = new Random();
        count = 0;
        speedNum = 100;
        speedNumTwo = 120;
        speedNumThree = 90;
        handler = new Handler();
        updateOne = new UpdateOne();
        updateTwo = new UpdateTwo();
        updateThree = new UpdateThree();
        for ( int i = 0; i < 3; i++) {
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.fruitview, null);
            imageViews[i].setMinimumWidth(350);
            imageViews[i].setMinimumHeight(350);
            imageViews[i].setImageDrawable(pear);
            grid.addView(imageViews[i]);
        }
        speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 1){
                    speedNum = 90;
                    speedNumTwo = 100;
                    speedNumThree = 80;
                }
                else if (progress == 2){
                    speedNum = 80;
                    speedNumTwo = 90;
                    speedNumThree = 70;
                }
                else if (progress == 3){
                    speedNum = 70;
                    speedNumTwo = 80;
                    speedNumThree = 60;
                }
                else if (progress == 4){
                    speedNum = 60;
                    speedNumTwo = 70;
                    speedNumThree = 50;
                }
                else if (progress == 5){
                    speedNum = 50;
                    speedNumTwo = 60;
                    speedNumThree = 40;
                }
                else {
                    speedNum = 100;
                    speedNumTwo = 120;
                    speedNumThree = 90;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void start(View v){
        handler.postDelayed(updateOne, speedNum);
        handler.postDelayed(updateTwo, speedNumTwo);
        handler.postDelayed(updateThree, speedNumThree);

    }
    public void stop(View v){
        handler.removeCallbacks(updateOne);
        handler.removeCallbacks(updateTwo);
        handler.removeCallbacks(updateThree);
        if (imageViews[0].getDrawable() == imageViews[1].getDrawable() && imageViews[0].getDrawable() == imageViews[2].getDrawable()){
           if (imageViews[0].getDrawable() == apple){
               count = 50 + count;
               score.setText(""+count);
           }
           else if (imageViews[0].getDrawable() == pear){
               count = 10 + count;
               score.setText(""+count);
           }
           else if (imageViews[0].getDrawable() == cherry){
               count = 100 + count;
               score.setText(""+count);
           }
        }
        }
    private class UpdateOne implements Runnable {
        @Override
        public void run() {
            if (imageViews[0].getDrawable() == apple){
                imageViews[0].setImageDrawable(pear);
            }
            else if (imageViews[0].getDrawable() == pear){
                imageViews[0].setImageDrawable(cherry);
            }
            else {
                imageViews[0].setImageDrawable(apple);
            }
            handler.postDelayed(updateOne, speedNum);
        }

    }
    private class UpdateTwo implements Runnable {
        @Override
        public void run() {
            if (imageViews[1].getDrawable() == apple){
                imageViews[1].setImageDrawable(pear);
            }
            else if (imageViews[1].getDrawable() == pear){
                imageViews[1].setImageDrawable(cherry);
            }
            else {
                imageViews[1].setImageDrawable(apple);
            }
            handler.postDelayed(updateTwo, speedNumTwo);
        }
    }
    private class UpdateThree implements Runnable {
        @Override
        public void run() {
            if (imageViews[2].getDrawable() == apple){
                imageViews[2].setImageDrawable(pear);
            }
            else if (imageViews[2].getDrawable() == pear){
                imageViews[2].setImageDrawable(cherry);
            }
            else {
                imageViews[2].setImageDrawable(apple);
            }
            handler.postDelayed(updateThree, speedNumThree);
        }

    }

    public void gameRules(View v){
        Intent i = new Intent(this, RulesActivity.class);
        startActivity(i);
    }



}
