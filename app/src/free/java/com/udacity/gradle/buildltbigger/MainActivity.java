package com.udacity.gradle.buildltbigger;

/**
 * Created by yodgorbekkomilov on 1/12/18.
 */

public class MainActivity extends AppCompatActivity {

    public void tellJoke(View view) {

        Context context = this;
        CharSequence text = this.getString(R.string.toast_text);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

}
