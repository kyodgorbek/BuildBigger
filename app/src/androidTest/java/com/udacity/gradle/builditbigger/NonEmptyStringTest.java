package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;
import android.util.Pair;

import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by yodgorbekkomilov on 1/8/18.
 */

public class NonEmptyStringTest  {

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
    }

}