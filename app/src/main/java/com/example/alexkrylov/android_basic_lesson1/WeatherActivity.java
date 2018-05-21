package com.example.alexkrylov.android_basic_lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        String city = "city";
        Parcel parcel = (Parcel) Objects.requireNonNull(getIntent().getExtras()).getSerializable(city);
        TextView textView = findViewById(R.id.city);
        assert parcel != null;
        textView.setText(parcel.city);
    }
}
