package com.example.alexkrylov.android_basic_lesson1;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "WeatherApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String instanceState;
        if(savedInstanceState == null) {
            instanceState = getString(R.string.first_start);
            Log.d(TAG, getString(R.string.first_start));
        } else {
            instanceState = getString(R.string.second_start);
            Log.d(TAG, getString(R.string.second_start));
        }
        Toast.makeText(getApplicationContext(), String.format("%s %s", instanceState, getString(R.string.on_create)), Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_create));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), R.string.on_start, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_start));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), R.string.on_restore_instance_state, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_restore_instance_state));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), R.string.on_resume, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_resume));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), R.string.on_pause, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_pause));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Toast.makeText(getApplicationContext(), R.string.on_save_instance_state, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_save_instance_state));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), R.string.on_stop, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_stop));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), R.string.on_restart, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_restart));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), R.string.on_destroy, Toast.LENGTH_SHORT).show();
        Log.d(TAG, getString(R.string.on_destroy));
    }
}
