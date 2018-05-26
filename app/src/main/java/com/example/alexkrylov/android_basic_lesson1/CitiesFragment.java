package com.example.alexkrylov.android_basic_lesson1;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CitiesFragment extends ListFragment {
    boolean isExistWeatherInfo;
    int currentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Cities, android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);

        View detailsFrame = getActivity().findViewById(R.id.weather_in_city);
        isExistWeatherInfo = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
        }

        if (isExistWeatherInfo) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CurrentCity", currentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showCityWeather();
    }

    private void showCityWeather() {
        if (isExistWeatherInfo) {
            getListView().setItemChecked(currentPosition, true);
            WeatherInCityFragment detail = (WeatherInCityFragment) getFragmentManager().findFragmentById(R.id.weather_in_city);
            if (detail == null || detail.getIndex() != currentPosition) {
                detail = WeatherInCityFragment.create(currentPosition);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.weather_in_city, detail);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), WeatherActivity.class);
            Parcel parcel = new Parcel();
            parcel.cityName = getResources().getStringArray(R.array.Cities)[currentPosition];
            intent.putExtra("index", currentPosition);
            intent.putExtra("city", parcel);
            startActivity(intent);
        }
    }
}

