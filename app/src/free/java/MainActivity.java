import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.R;

/**
 * Created by yodgorbekkomilov on 1/11/18.
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


