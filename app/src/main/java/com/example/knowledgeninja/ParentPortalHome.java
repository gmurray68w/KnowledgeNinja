package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class ParentPortalHome extends AppCompatActivity {

    Button btnSave, btnCancel;
    //Space cbs
    CheckBox cbppSolarSystem, cbppTechnology, cbppComets;

    //Nature cbs
    CheckBox cbppTrees, cbppFlowers, cbppSeasons;

    //Animals
    CheckBox cbppMammals, cbppReptiles, cbppBirds;

    //Technology
    CheckBox cbppAI, cbppRobotics, cbppCoding;

    //History
    CheckBox cbppAmerican, cbppArt, cbppMusical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_portal_home);

        //Space
        cbppSolarSystem = findViewById(R.id.cbPPSolarSystem);
        cbppTechnology = findViewById(R.id.cbPPTechnology);
        cbppComets = findViewById(R.id.cbPPComets);
        //Nature
        cbppTrees = findViewById(R.id.cbPPTrees);
        cbppFlowers = findViewById(R.id.cpPPFlowers);
        cbppSeasons = findViewById(R.id.cbPPSeasons);
        //Animals
        cbppMammals = findViewById(R.id.cbPPMammals);
        cbppReptiles = findViewById(R.id.cbPPReptiles);
        cbppBirds = findViewById(R.id.cbPPBirds);
        //Technology
        cbppAI= findViewById(R.id.cbPPAI);
        cbppRobotics = findViewById(R.id.cbPPRobotics);
        cbppCoding = findViewById(R.id.cbPPCoding);
        //History
        cbppAmerican = findViewById(R.id.cbPPAmerican);
        cbppArt = findViewById(R.id.cbPPArt);
        cbppMusical = findViewById(R.id.cbPPMusical);

        //Buttons
        btnSave = findViewById(R.id.buttonSaveParentalcontrols);
        btnCancel = findViewById(R.id.buttonCancelParentalPortal);

        //Import universal variables and check all the boxes that are active.
        //Take universal variables for each checkbox
        //Set universal variables.

        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean checkbox1Value = prefs.getBoolean("checkbox1", false);
        boolean checkbox2Value = prefs.getBoolean("checkbox2", false);
        boolean checkbox3Value = prefs.getBoolean("checkbox3", false);
        boolean checkbox4Value = prefs.getBoolean("checkbox4", false);
        boolean checkbox5Value = prefs.getBoolean("checkbox5", false);
        boolean checkbox6Value = prefs.getBoolean("checkbox6", false);
        boolean checkbox7Value = prefs.getBoolean("checkbox7", false);
        boolean checkbox8Value = prefs.getBoolean("checkbox8", false);
        boolean checkbox9Value = prefs.getBoolean("checkbox9", false);
        boolean checkbox10Value = prefs.getBoolean("checkbox10", false);
        boolean checkbox11Value = prefs.getBoolean("checkbox11", false);
        boolean checkbox12Value = prefs.getBoolean("checkbox12", false);
        boolean checkbox13Value = prefs.getBoolean("checkbox13", false);
        boolean checkbox14Value = prefs.getBoolean("checkbox14", false);
        boolean checkbox15Value = prefs.getBoolean("checkbox15", false);

// Repeat the above two lines for checkbox3 to checkbox15

        if (!prefs.contains("checkbox1") && !prefs.contains("checkbox2") && !prefs.contains("checkbox3")
                && !prefs.contains("checkbox4") && !prefs.contains("checkbox5") && !prefs.contains("checkbox6")
                && !prefs.contains("checkbox7") && !prefs.contains("checkbox8") && !prefs.contains("checkbox9")
                && !prefs.contains("checkbox10") && !prefs.contains("checkbox11") && !prefs.contains("checkbox12")
                && !prefs.contains("checkbox13") && !prefs.contains("checkbox14") && !prefs.contains("checkbox15")) {
            // No values in SharedPreferences, check all checkboxes by default
            cbppSolarSystem.setChecked(true);
            cbppTechnology.setChecked(true);
            cbppComets.setChecked(true);

            cbppTrees.setChecked(true);
            cbppFlowers.setChecked(true);
            cbppSeasons.setChecked(true);

            cbppMammals.setChecked(true);
            cbppReptiles.setChecked(true);
            cbppBirds.setChecked(true);

            cbppAI.setChecked(true);
            cbppRobotics.setChecked(true);
            cbppCoding.setChecked(true);

            cbppAmerican.setChecked(true);
            cbppArt.setChecked(true);
            cbppMusical.setChecked(true);

        } else {
            // Set checkbox values based on SharedPreferences
            cbppSolarSystem.setChecked(checkbox1Value);
            cbppTechnology.setChecked(checkbox2Value);
            cbppComets.setChecked(checkbox3Value);

            cbppTrees.setChecked(checkbox4Value);
            cbppFlowers.setChecked(checkbox5Value);
            cbppSeasons.setChecked(checkbox6Value);

            cbppMammals.setChecked(checkbox7Value);
            cbppReptiles.setChecked(checkbox8Value);
            cbppBirds.setChecked(checkbox9Value);

            cbppAI.setChecked(checkbox10Value);
            cbppRobotics.setChecked(checkbox11Value);
            cbppCoding.setChecked(checkbox12Value);

            cbppAmerican.setChecked(checkbox13Value);
            cbppArt.setChecked(checkbox14Value);
            cbppMusical.setChecked(checkbox15Value);
            // Repeat the above two lines for checkbox3 to checkbox15
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                                           SharedPreferences.Editor editor = prefs.edit();
                                           //Space buttons
                                           editor.putBoolean("checkbox1", cbppSolarSystem.isChecked());
                                           editor.putBoolean("checkbox2", cbppTechnology.isChecked());
                                           editor.putBoolean("checkbox3", cbppComets.isChecked());

                                           //Nature buttons
                                           editor.putBoolean("checkbox4", cbppTrees.isChecked());
                                           editor.putBoolean("checkbox5", cbppFlowers.isChecked());
                                           editor.putBoolean("checkbox6", cbppSeasons.isChecked());


                                           //Animals buttons
                                           editor.putBoolean("checkbox7", cbppMammals.isChecked());
                                           editor.putBoolean("checkbox8", cbppReptiles.isChecked());
                                           editor.putBoolean("checkbox9", cbppBirds.isChecked());

                                           //Tech buttons
                                           editor.putBoolean("checkbox10", cbppAI.isChecked());
                                           editor.putBoolean("checkbox11", cbppRobotics.isChecked());
                                           editor.putBoolean("checkbox12", cbppCoding.isChecked());

                                           //History Buttons

                                           editor.putBoolean("checkbox13", cbppAmerican.isChecked());
                                           editor.putBoolean("checkbox14", cbppArt.isChecked());
                                           editor.putBoolean("checkbox15", cbppMusical.isChecked());
                                           editor.apply();
                                           Intent i = new Intent(ParentPortalHome.this, MainMenu.class);
                                           startActivity(i);
                                       }
                                   }
        );





    }
}