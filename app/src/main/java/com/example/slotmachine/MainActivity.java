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
    private TextView speedNum;
    private UpdateOne updateOne;
    private UpdateTwo updateTwo;
    private UpdateThree updateThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.gridLayout);
        apple = getDrawable(R.drawable.apple);
        cherry = getDrawable(R.drawable.apple);
        pear = getDrawable(R.drawable.apple);
        score = findViewById(R.id.score);
        speed = findViewById(R.id.speedBar);
        stop = findViewById(R.id.stop);
        start = findViewById(R.id.start);
        speedNum = findViewById(R.id.speed);
        imageViews = new ImageView[3];
        rand = new Random();
        count = 0;
        handler = new Handler();
        fruitLocation = rand.nextInt(3);
        for ( int i = 0; i < 3; i++) {
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.fruitview, null);
            imageViews[i].setMinimumWidth(350);
            imageViews[i].setMinimumHeight(350);
            imageViews[i].setImageDrawable(apple);
            grid.addView(imageViews[i]);
        }
        speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                speedNum.setText(progress + "");
                handler.postDelayed(progress + 20);
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
        handler.postDelayed(updateOne, 1000);
        handler.postDelayed(updateTwo, 1000);
        handler.postDelayed(updateThree, 1000);

    }
    public void stop(View v){
        handler.postDelayed(updateOne, 0);
        handler.postDelayed(updateTwo, 0);
        handler.postDelayed(updateThree, 0);
        if (imageViews == apple){
            score.setText(score + "50");
        }
        else if (imageViews == pear){
            score.setText(score + "10");
        }
        else (imageViews == cherry){
            score.setText(score + "100");
        }
    }
    private class UpdateOne implements Runnable {
        @Override
        public void run() {
            imageViews[fruitLocation].setImageDrawable(null);
            fruitLocation = rand.nextInt(3);
            if (imageViews == apple){
                imageViews[fruitLocation].setImageDrawable(pear);
            }
            else if (imageViews == pear){
                imageViews[fruitLocation].setImageDrawable(cherry);
            }
            else (imageViews == cherry){
                imageViews[fruitLocation].setImageDrawable(apple);
            }
            handler.postDelayed(updateOne, 1000);
        }

    }
    private class UpdateTwo implements Runnable {
        @Override
        public void run() {
            imageViews[fruitLocation].setImageDrawable(null);
            fruitLocation = rand.nextInt(3);
            if (imageViews == apple){
                imageViews[fruitLocation].setImageDrawable(pear);
            }
            else if (imageViews == pear){
                imageViews[fruitLocation].setImageDrawable(cherry);
            }
            else (imageViews == cherry){
                imageViews[fruitLocation].setImageDrawable(apple);
            }
            handler.postDelayed(updateTwo, 1000);
        }
    }
    private class UpdateThree implements Runnable {
        @Override
        public void run() {
            imageViews[fruitLocation].setImageDrawable(null);
            fruitLocation = rand.nextInt(3);
            if (imageViews == apple){
                imageViews[fruitLocation].setImageDrawable(pear);
            }
            else if (imageViews == pear){
                imageViews[fruitLocation].setImageDrawable(cherry);
            }
            else (imageViews == cherry){
                imageViews[fruitLocation].setImageDrawable(apple);
            }
            handler.postDelayed(updateThree, 1000);
        }

    }

    public void gameRules(View v){
        Intent i = new Intent(this, RulesActivity.class);
        startActivity(i);
    }



}
