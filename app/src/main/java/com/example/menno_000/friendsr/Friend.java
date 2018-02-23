package com.example.menno_000.friendsr;

import java.io.Serializable;

/**
 * Created by menno_000 on 22-2-2018.
 */

// Creating the friends class
public class Friend implements Serializable {
    // Initialising the variables of all friends
    private String name, bio;
    private int drawableId;
    private float rating;

    // Creating a friend constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // Make it possible to retrieve values of each friend
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    // Make it possible to set the rating value of each friend
    public void setRating(float rating) {
        this.rating = rating;
    }
}
