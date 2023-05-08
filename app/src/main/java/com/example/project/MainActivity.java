package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {

        super.onResume();
        //Hämta text
        myPreferenceRef = getSharedPreferences("shareBetweenActivity", Context.MODE_PRIVATE);
        //sätt in text i TextView
        TextView prefTextRef = new TextView(this);
        prefTextRef = (TextView) findViewById(R.id.prefText);
        prefTextRef.setText(myPreferenceRef.getString("name", "No preference found."));
    }

    public void goToSecond(View v){
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }



}
