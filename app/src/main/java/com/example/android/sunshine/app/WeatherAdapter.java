package com.example.android.sunshine.app;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Josmary on 6/28/15.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {
    private static final String LOG_TAG = WeatherAdapter.class.getSimpleName();


    public WeatherAdapter(Activity context, List<Weather> weatherList) {
        super(context, 0, weatherList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Gets the AndroidFlavor object from the ArrayAdapter at the appropriate position
        Weather weather = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_forecast, parent, false);
        }

        TextView dayView = (TextView) convertView.findViewById(R.id.list_item_date_textview);
        dayView.setText(weather.day);

        TextView descriptionView = (TextView) convertView.findViewById(R.id.list_item_forecast_textview);
        descriptionView.setText(weather.description);

        TextView highView = (TextView) convertView.findViewById(R.id.list_item_high_textview);
        highView.setText(weather.high);

        TextView lowView = (TextView) convertView.findViewById(R.id.list_item_low_textview);
        lowView.setText(weather.low);

        ImageView iconView = (ImageView) convertView.findViewById(R.id.list_item_icon);
        iconView.setImageResource(weather.image);


        return convertView;
    }
}
