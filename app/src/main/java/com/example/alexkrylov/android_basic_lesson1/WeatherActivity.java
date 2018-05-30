package com.example.alexkrylov.android_basic_lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

import java.util.Objects;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if(savedInstanceState == null) {
            WeatherInCityFragment weatherInCityFragment = new WeatherInCityFragment();
            weatherInCityFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, weatherInCityFragment).commit();
       }

        String city = "city";
        Parcel parcel = (Parcel) Objects.requireNonNull(getIntent().getExtras()).getSerializable(city);
        TextView textView = findViewById(R.id.city);
        assert parcel != null;
        textView.setText(parcel.cityName);
    }
}
