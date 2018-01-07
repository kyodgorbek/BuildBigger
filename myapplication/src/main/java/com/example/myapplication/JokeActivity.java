package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "Joke key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity_main);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        TextView textView = (TextView) findViewById(R.id.jokeTextView);
        if (joke != null && joke.length() != 0) {
            textView.setText(joke);
        }


    }
}
