package com.example.menno_000.friendsr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialising the array in which all friends can be stored
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding the friends to the array
        friends.add("Chandler", "An awkward guy", getResources().getIdentifier());
        friends.add("Joey", "A womanizer guy", getResources().getIdentifier());
        friends.add("Monica", "A neurotic girl", getResources().getIdentifier());
        friends.add("Phoebe", "A standoffish girl", getResources().getIdentifier());
        friends.add("Rachel", "A priveledged girl", getResources().getIdentifier());
        friends.add("Ross", "A stubborn guy", getResources().getIdentifier());
    }
}