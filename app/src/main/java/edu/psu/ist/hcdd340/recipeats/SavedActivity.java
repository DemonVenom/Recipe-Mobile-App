package edu.psu.ist.hcdd340.recipeats;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class SavedActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linearLayout;

    public static final String EXTRA_RECIPE_PIC = "PROFILE_PIC";


    private static int imageID;


    private static boolean hasView;


    /**
     * onCreate() method where the saved recipes activity is intialized
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);


        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        scrollView.setLayoutParams(layoutParams);

        linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(linearParams);

        scrollView.addView(linearLayout);


        hasView = false;


        addNewView();
        addEmptyViewCheck();




        LinearLayout linearLayout1 = findViewById(R.id.layout);
        if (linearLayout1 != null) {
            linearLayout1.addView(scrollView);
        }

    }



    @Override
    public void onClick(View view) {
        //Handle onClick events

        switch (view.getId()) {
            case 1000123:
                setCurrentProfile(0);
                handleRecipe();
                break;


            case 1000124:

                setCurrentProfile(1);
                handleRecipe();
                break;


            case 1000125:

                setCurrentProfile(2);
                handleRecipe();
                break;
        }
    }



    private void handleRecipe() {

        // Create new intent on SettingsActivity class
        Intent intent = new Intent(this, RecipeActivity.class);

        intent.putExtra(EXTRA_RECIPE_PIC, getCurrentProfile());
        startActivity(intent);

    }



    private int setCurrentProfile(int viewID) {

        imageID = viewID;
        return imageID;
    }


    private int getCurrentProfile() {
        return imageID;
    }



    @SuppressLint("ResourceType")
    private void addNewView() {

        for (int i = 0; i < MainActivity.RECIPE_PROFILES.length; i++) {

            if (MainActivity.RECIPE_PROFILES[i].getProfileLikeStatus() == true) {

                //Initialising new layout
                ShapeableImageView imageView = new ShapeableImageView(SavedActivity.this);

                TextView textView = new TextView(SavedActivity.this);

                //Setting the image in the layout
                imageView.setImageResource(MainActivity.RECIPE_PROFILES[i].getProfileImageID());

                textView.setText(MainActivity.RECIPE_PROFILES[i].getProfileName());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, 600);

                // setting the margin in linearlayout
                params.setMargins(0, 10, 0, 10);
                params.gravity = Gravity.CENTER;

                imageView.setLayoutParams(params);
                textView.setLayoutParams(params);


                imageView.setOnClickListener(this);

                imageView.setId(1000123 + i);


                //Adding the image in layout
                linearLayout.addView(imageView);

                //Adding the text in layour
                linearLayout.addView(textView);

                hasView = true;
            }

        }
    }


    private void addEmptyViewCheck() {

        if (hasView == false) {

            //Initialising new layout
            ShapeableImageView imageView = new ShapeableImageView(SavedActivity.this);

            //Initialising new textView
            TextView textView = new TextView(SavedActivity.this);


            //Setting the image in the layout
            imageView.setImageResource(R.drawable.icon_empty_cart);

            textView.setText(R.string.empty_saved_recipes);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(600, 600);

            //Setting the margin in linearlayout
            params.setMargins(0, 10, 0, 10);
            params.gravity = Gravity.CENTER;

            imageView.setLayoutParams(params);
            textView.setLayoutParams(params);

            //Adding the image in layout
            linearLayout.addView(imageView);

            //Adding the textview in layout
            linearLayout.addView(textView);

        }

    }


}