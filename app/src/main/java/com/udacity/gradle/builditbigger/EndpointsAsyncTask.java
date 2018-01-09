package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lib100.Joker;
import com.example.myapplication.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by yodgorbekkomilov on 1/4/18.
 */

 class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
private static MyApi myApiService = null;
private Context context;

        public EndpointsAsyncTask() {
        }

        public EndpointsAsyncTask(Context context, Object o) {
        }

        @Override
protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
        new AndroidJsonFactory(), null)



        // options for running against local devappserver
        // - 10.0.2.2 is localhost's IP address in Android emulator
        // - turn off compression when running against local devappserver
        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
@Override
public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        abstractGoogleClientRequest.setDisableGZipContent(true);
        }
        });
        // end options for devappserver

        myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
                return myApiService.getJoke().execute().getData();

        } catch (IOException e) {
        return e.getMessage();
        }
        }

        @Override
        protected void onPostExecute(String result) {
                Intent intent = new Intent(getContext(), JokeActivity.class);
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra( MainActivity.JOKE_KEY, myJoker.getJoke());
        }
        }


