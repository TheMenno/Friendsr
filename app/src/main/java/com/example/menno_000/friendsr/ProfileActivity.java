package com.example.menno_000.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences prefs;
    RatingBar ratingBar;
    Friend retrievedFriend;

    ImageView profilepic;
    TextView profilename;
    TextView profilebio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // 'Opening' the intent given by the previous page
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // Retrieving and setting the profile picture
        profilepic = findViewById(R.id.profileid);
        profilepic.setImageResource(retrievedFriend.getDrawableId());

        // Retrieving and setting the profile name
        profilename = findViewById(R.id.profilename);
        profilename.setText(retrievedFriend.getName());

        // Retrieving and setting the profile bio
        profilebio = findViewById(R.id.profilebio);
        profilebio.setText(retrievedFriend.getBio());

        // Get the stored data from SharedPreferences
        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float retrievedFloat = prefs.getFloat(retrievedFriend.getName(),0);

        // If the data exists, show it
        if (retrievedFloat != 0) {
            retrievedFriend.setRating(retrievedFloat);

            // Set the correct value on the ratingbar
            ratingBar = findViewById(R.id.ratingBar);
            ratingBar.setRating(retrievedFloat);
        }

        // Initialise the listener
        RatingBarListener();
    }

    // Creating the listener
    public void RatingBarListener() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                // If the rating changes, set the new rating
                retrievedFriend.setRating(v);
                SharedPreferences.Editor editor = prefs.edit();

                // Save the change
                editor.putFloat(retrievedFriend.getName(), v);
                editor.apply();
            }
        });
    }
}
