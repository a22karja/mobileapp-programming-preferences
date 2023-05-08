package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPreferenceRef = getSharedPreferences("shareBetweenActivity", Context.MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

    }

    public void savePref(View v){
        //Hämta text
        EditText newPrefText;
        newPrefText=(EditText)findViewById(R.id.settingseditview);

        //spara till Shared Preferences
        myPreferenceEditor.putString("name", newPrefText.getText().toString());
        myPreferenceEditor.commit();


        // reset
        newPrefText.setText("");
        startActivity(new Intent(SecondActivity.this, MainActivity.class));
    }


}