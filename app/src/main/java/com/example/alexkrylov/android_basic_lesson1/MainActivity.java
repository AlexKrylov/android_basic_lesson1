package com.example.alexkrylov.android_basic_lesson1;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "WeatherApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.choose_city);
        Button button = findViewById(R.id.show_weather);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Parcel parcel = new Parcel();
                parcel.city = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra("city", parcel);
                startActivity(intent);
            }
        });

        if (savedInstanceState == null) {
            Log.d(TAG, getString(R.string.first_start));
        } else {
            Log.d(TAG, getString(R.string.second_start));
        }
        Log.d(TAG, getString(R.string.on_create));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, getString(R.string.on_start));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, getString(R.string.on_restore_instance_state));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, getString(R.string.on_resume));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, getString(R.string.on_pause));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, getString(R.string.on_save_instance_state));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, getString(R.string.on_stop));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, getString(R.string.on_restart));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, getString(R.string.on_destroy));
    }
}
