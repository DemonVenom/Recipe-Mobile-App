package edu.psu.ist.hcdd340.recipeats;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.View;

import com.google.android.material.imageview.ShapeableImageView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public static RecipeProfile[] RECIPE_PROFILES = {

            //Create the three recipes and their respective profiles
            new RecipeProfile(R.string.name_fruit_salad, R.string.desc_fruit_salad, false, R.drawable.fruit_salad),
            new RecipeProfile(R.string.name_popcorn_chicken, R.string.desc_popcorn_chicken, false, R.drawable.popcorn_chicken),
            new RecipeProfile(R.string.name_spaghetti, R.string.desc_spaghetti, false, R.drawable.spaghetti_and_meat_sauce),

    };

    //Main attributes
    private static final String TAG = "RECIPEATS_ACTIVITY";
    public static final String EXTRA_RECIPE_PIC = "PROFILE_PIC";
    private static int imageID;


    /**
     * onCreate() method where the main activity is intialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Call the super onCreate() method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //set the respective view

        //Create the 'Liked' recipe button and set listener
        ShapeableImageView button = findViewById(R.id.imageLike);
        button.setOnClickListener(this);

        //Create the 'Search' recipe button and set listener
        button = findViewById(R.id.imageSearch);
        button.setOnClickListener(this);

        //Create the 'Settings' button and listener
        button = findViewById(R.id.imageSettings);
        button.setOnClickListener(this);


        //Create the recipe button and listener for recipe 1 image
        button = findViewById(R.id.image_fruit_salad);
        button.setOnClickListener(this);

        //Create the recipe button and listener for recipe 2 image
        button = findViewById(R.id.image_popcorn_chicken);
        button.setOnClickListener(this);

        //Create the recipe button and listener for recipe 3 image
        button = findViewById(R.id.image_spaghetti);
        button.setOnClickListener(this);

        //Create the like recipe button and listener for recipe 1
        button = findViewById(R.id.like_fruit_salad);
        button.setOnClickListener(this);

        //Create the like recipe button and listener for recipe 2
        button = findViewById(R.id.like_popcorn_chicken);
        button.setOnClickListener(this);

        //Create the like recipe button and listener for recipe 3
        button = findViewById(R.id.like_spaghetti);
        button.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        //Handle onClick events

        switch (view.getId()) {
            case R.id.imageLike:
                handleLike();
                break;

            case R.id.imageSearch:
                break;

            case R.id.imageSettings:
                handleSettings();
                break;

            case R.id.image_fruit_salad:
                setCurrentProfile(0);
                handleRecipe();
                break;

            case R.id.image_popcorn_chicken:
                setCurrentProfile(1);
                handleRecipe();
                break;

            case R.id.image_spaghetti:
                setCurrentProfile(2);
                handleRecipe();
                break;

            case R.id.like_fruit_salad:
                markIconAsSelected(R.id.like_fruit_salad, 0);
                break;

            case R.id.like_popcorn_chicken:
                markIconAsSelected(R.id.like_popcorn_chicken, 1);
                break;

            case R.id.like_spaghetti:
                markIconAsSelected(R.id.like_spaghetti, 2);
                break;


        }
    }


    private void handleLike() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, SavedActivity.class);
        startActivity(intent);

    }


    private void handleSettings() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

    private void handleRecipe() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_RECIPE_PIC, getCurrentProfile());
        startActivity(intent);

    }



    private int setCurrentProfile(int viewID) {
        //Set the current profile to appear on the application and return that image
        imageID = viewID;
        return imageID;
    }


    private int getCurrentProfile() {
        //Return the image ID of the current recipe profile that is being shown
        return imageID;
    }


    private void markIconAsSelected(int iconId, int index) {
        //Now update the background
        ShapeableImageView iconView = findViewById(iconId);

        boolean likeStatus = RECIPE_PROFILES[index].getProfileLikeStatus();


        if (likeStatus == false) {
            iconView.setBackgroundColor(ContextCompat.getColor(this, R.color.darker_gray));
        }
        else {
            iconView.setBackgroundColor(ContextCompat.getColor(this, R.color.light_gray));
        }

        RECIPE_PROFILES[index].setProfileLikeStatus( !likeStatus );

    }


}