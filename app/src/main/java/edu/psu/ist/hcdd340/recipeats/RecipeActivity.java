package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class RecipeActivity extends AppCompatActivity implements View.OnClickListener {



    private static final String TAG = "ACTIVITY_RECIPE";



    /**
     * onCreate() method where the current recipe activity is intialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        int image = intent.getIntExtra(MainActivity.EXTRA_RECIPE_PIC, 0);


        Log.d(TAG, "" + image);


        ShapeableImageView view;
        view = findViewById(R.id.image_fruit_salad);


        TextView textView;
        textView = findViewById(R.id.textIngredients);

        TextView textViewName;
        textViewName = findViewById(R.id.textRecipeName);



        view.setImageResource(MainActivity.RECIPE_PROFILES[image].getProfileImageID());
        textView.setText(MainActivity.RECIPE_PROFILES[image].getProfileDesc());
        textViewName.setText(MainActivity.RECIPE_PROFILES[image].getProfileName());



        Log.d(TAG, "On Create");

    }

    //Must override onClick() method to run
    @Override
    public void onClick(View view) {

    }










}