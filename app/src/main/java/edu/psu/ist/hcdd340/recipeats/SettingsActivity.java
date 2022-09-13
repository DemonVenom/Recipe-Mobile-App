package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ACTIVITY_SETTINGS";


    /**
     * onCreate() method where the settings activity is intialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Log.d(TAG, "On Create");

    }


    //Method needs to be overriden to run
    @Override
    public void onClick(View view) {

    }

}