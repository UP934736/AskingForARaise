package com.example.askingforaraise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startButton (View view){
        Intent switchActs = new Intent(MainActivity.this, GameScreen.class);
        startActivity(switchActs);
    }
}