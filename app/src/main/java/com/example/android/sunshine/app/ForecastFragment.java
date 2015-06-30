package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by Josmary on 6/28/15.
 */
public class ForecastFragment extends Fragment {

    WeatherAdapter weatherAdapter;;

    public ForecastFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            FetchWeatherTask weatherTask = new FetchWeatherTask();
            weatherTask.execute("94043");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Weather[] weatherList = {
                new Weather("Tomorrow","Foggy", "21", "8", R.drawable.cloud),
                new Weather("Tue 6/24","Cloudy", "22", "17", R.drawable.cloud),
                new Weather("Wed 6/25 ","Rainy", "18", "11", R.drawable.cloud),
                new Weather("Thurs 6/26","Foggy", "21", "10", R.drawable.cloud),
                new Weather("Fri 6/27","TRAPPED IN WEATHERSTATION", "23", "18", R.drawable.cloud),
                new Weather("Sat 6/28","Sunny", "20", "7", R.drawable.cloud),
                new Weather("Sun 6/29","Cloudy", "10", "8", R.drawable.cloud),

        };


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        weatherAdapter = new WeatherAdapter(getActivity(), Arrays.asList(weatherList));

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(weatherAdapter);

        return rootView;

    }
}