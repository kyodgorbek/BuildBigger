package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.myapplication.*;

/**
 * Created by yodgorbekkomilov on 1/12/18.
 */

public class PaidActivity extends AppCompatActivity {



    public void tellJoke(View view) {
        Intent jokeIntent = new Intent(this, JokeActivity.class);
        startActivity(jokeIntent);
    }

}
