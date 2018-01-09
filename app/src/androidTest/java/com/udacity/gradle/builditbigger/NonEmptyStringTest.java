package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import com.example.myapplication.JokeActivity;

import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by yodgorbekkomilov on 1/8/18.
 */

public class NonEmptyStringTest {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @Test
    public void test() {
        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("NonEmptyStringTest", "Running NonEmptyStringTest test");
        String result = null;
        EndpointsAsyncTask task = new EndpointsAsyncTask(getContext(), null);
        task.execute(new Pair<Context, String>(getContext(), ""));
        try {
            result = task.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);

        @SuppressLint("StaticFieldLeak") EndpointsAsyncTask tasks = new EndpointsAsyncTask() {
            protected void onPostExecute(String result, Pair<Context, String>... params) {


            }

        };
        tasks.execute(new Pair<Context, String>(getContext(), ""));

        // Use an AsyncTask to request by the backend.
        // When the AsyncTask ends, get the joke received from the AsyncTask and start the Joke activity
    }
}




