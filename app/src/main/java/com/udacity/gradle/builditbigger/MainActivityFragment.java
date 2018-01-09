package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lib100.*;
import com.example.myapplication.*;
import android.util.Pair;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String JOKE_KEY = "Joke key";
    public MainActivityFragment() {
    }

    public static MainActivityFragment newInstance(Bundle arg){
        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.setArguments(arg);

        return mainActivityFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final Joker myJoker = new Joker();
        TextView textView = (TextView) rootView.findViewById(R.id.instructions_text_view);
        Button button = (Button) rootView.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //execute the async task
                @SuppressLint("StaticFieldLeak") EndpointsAsyncTask task = new EndpointsAsyncTask(){
                    protected void onPostExecute( String result) {
                        Intent intent = new Intent(getContext(), JokeActivity.class);
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra( MainActivity.JOKE_KEY, myJoker.getJoke());
                       startActivity(intent);



                    }

                };
                task.execute(new Pair<Context, String>(getContext(), ""));

                // Use an AsyncTask to request by the backend.
                // When the AsyncTask ends, get the joke received from the AsyncTask and start the Joke activity
            }
        });


         //textView.setText(myJoker.getJoke());







        // Toast.makeText(this, Joker.class, "Hey I am joker  ", Toast.LENGTH_LONG).show();


        // AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        //AdRequest adRequest = new AdRequest.Builder()
        //       .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        //     .build();
        //mAdView.loadAd(adRequest);
        return rootView;
    }
}
