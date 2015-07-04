package com.example.android.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Josmary on 6/28/15.
 */
public class ForecastFragment extends Fragment {

    public static WeatherAdapter weatherAdapter;

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

        final ArrayList<Weather> weatherList = new ArrayList<Weather>();


        weatherList.add(new Weather("Tomorrow","Foggy", "21", "8", R.drawable.cloud));


        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        weatherAdapter = new WeatherAdapter(getActivity(), weatherList);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(weatherAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Weather weather = weatherAdapter.getItemList().get(i);
                String text = weather.day + " " + weather.description + " " + weather.high + " " + weather.low;
                Intent downloadIntent = new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, text);
                startActivity(downloadIntent);

            }
        });

        return rootView;

    }
}