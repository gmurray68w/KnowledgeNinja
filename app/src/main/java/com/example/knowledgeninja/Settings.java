package com.example.knowledgeninja;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Settings extends AppCompatActivity {
  Switch themeTog;
  Boolean drkTheme = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        themeTog = findViewById(R.id.themeTog);


        themeTog.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (themeTog.isChecked() == true) {
              AppCompatDelegate
                .setDefaultNightMode(
                  AppCompatDelegate
                    .MODE_NIGHT_NO);
              //themeTog.setChecked(false);
            }
            else {
              AppCompatDelegate
                .setDefaultNightMode(
                  AppCompatDelegate
                    .MODE_NIGHT_YES);
              //themeTog.setChecked(true);
            }

          }
        });

    }

@Override
  protected void onResume() {
      super.onResume();
}



}
