package com.example.menno_000.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by menno_000 on 23-2-2018.
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private Context context;
    private Integer resource;
    private ArrayList friends;

    public ImageView images;
    public TextView names;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> friends) {
        super(context, resource, friends);
        this.context = context;
        this.resource = resource;
        this.friends = friends;
    }

    @NonNull
    @Override
    // Look for which friend was clicked
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Friend friend = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Get data about the person
        String name = friend.getName();
        Integer id = friend.getDrawableId();

        // Set the data in the profile view
        images = convertView.findViewById(R.id.images);
        images.setImageResource(id);

        names = convertView.findViewById(R.id.names);
        names.setText(name);


        return convertView;
    }
}
