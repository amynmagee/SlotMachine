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
    private ImageView[] imageViews;
    private Random rand;
    public int count;
    public Handler handler;
    private int fruitLocation;

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
        imageViews = new ImageView[3];
        rand = new Random();
        count = 0;
        handler = new Handler();
        fruitLocation = rand.nextInt(3);
        for (int i = 0; i < 3; i++) {
            imageViews[i] = (ImageView) getLayoutInflater().inflate(R.layout.fruitview, null);
            imageViews[i].setMinimumWidth(270);
            imageViews[i].setMinimumHeight(270);
            if (i == fruitLocation) imageViews[i].setImageDrawable(apple);
            grid.addView(imageViews[i]);
        }
        speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void stopGo(View v){

    }

    public void gameRules(View v){
        Intent i = new Intent(this, RulesActivity.class);
        startActivity(i);
    }



}
