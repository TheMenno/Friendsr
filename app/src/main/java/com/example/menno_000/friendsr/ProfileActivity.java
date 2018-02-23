package com.example.menno_000.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        ImageView profilepic = findViewById(R.id.profileid);
        profilepic.setImageResource(retrievedFriend.getDrawableId());

        TextView profilename = findViewById(R.id.profilename);
        profilename.setText(retrievedFriend.getName());

        TextView profilebio = findViewById(R.id.profilebio);
        profilebio.setText(retrievedFriend.getBio());
    }
}
