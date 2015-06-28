package com.example.android.sunshine.app;

/**
 * Created by Josmary on 6/28/15.
 */
public class Weather {

    String day;
    String description;
    String low;
    String high;
    int image; // drawable reference id

    public Weather(String day, String description, String low, String high, int image)
    {
        this.day = day;
        this.description = description;
        this.low = low;
        this.high = high;
        this.image = image;
    }
}
