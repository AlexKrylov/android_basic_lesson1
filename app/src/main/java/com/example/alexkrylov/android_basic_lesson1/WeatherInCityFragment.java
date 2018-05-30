package com.example.alexkrylov.android_basic_lesson1;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class WeatherInCityFragment extends Fragment{
    public static  WeatherInCityFragment create(int index) {
        WeatherInCityFragment weatherInCityFragment = new WeatherInCityFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        weatherInCityFragment.setArguments(bundle);
        return weatherInCityFragment;
    }

    public int getIndex(){
        return getArguments().getInt("index", 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = new ImageView(getActivity());
        @SuppressLint("Recycle") TypedArray img = getResources().obtainTypedArray(R.array.weather_city_imgs);
        imageView.setImageResource(img.getResourceId(getIndex(), -1));
        return imageView;
    }
}
