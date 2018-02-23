package com.example.menno_000.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            // Toast.makeText(MainActivity.this, clickedFriend.getName().toString(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising the array in which all friends can be stored
        ArrayList<Friend> friends = new ArrayList<>();

        // Initialising the friends-adapter
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // Adding the friends to the array
        Friend Chandler = new Friend("Chandler", "An awkward guy", getResources().getIdentifier("friendschandler", "drawable", MainActivity.this.getPackageName()));
        Friend Joey = new Friend("Joey", "A womanizer", getResources().getIdentifier("friendsjoey", "drawable", MainActivity.this.getPackageName()));
        Friend Monica = new Friend("Monica", "A neurotic girl", getResources().getIdentifier("friendsmonica", "drawable", MainActivity.this.getPackageName()));
        Friend Phoebe = new Friend("Phoebe", "A standoffish girl", getResources().getIdentifier("friendsphoebe", "drawable", MainActivity.this.getPackageName()));
        Friend Rachel = new Friend("Rachel", "A privileged girl", getResources().getIdentifier("friendsrachel", "drawable", MainActivity.this.getPackageName()));
        Friend Ross = new Friend("Ross", "A stubborn guy", getResources().getIdentifier("friendsross", "drawable", MainActivity.this.getPackageName()));

        Collections.addAll(friends, Chandler, Joey, Monica, Phoebe, Rachel, Ross);

        GridView gv = findViewById(R.id.grid);
        gv.setOnItemClickListener(new GridItemClickListener());

        GridView grid = findViewById(R.id.grid);
        grid.setAdapter(adapter);

    }
}