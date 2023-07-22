package com.example.knowledgeninja;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.knowledgeninja.R;

public class Data extends AppCompatActivity implements View.OnClickListener {

    TextView testPage;
    TextView textViewA;
    TextView textViewB;
    TextView textViewC;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageGameView;
    String choice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //SpaceValues
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        testPage = findViewById(R.id.testTextView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        textViewA = findViewById(R.id.textViewA);
        textViewB = findViewById(R.id.textViewB);
        textViewC = findViewById(R.id.textViewC);
        imageGameView = findViewById(R.id.imageGameView);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        testPage.setText(str);
        Toast.makeText(this, "User Selected: " + str, Toast.LENGTH_LONG).show();

        if ("Space".equals(str))
        {
            testPage.setText(R.string.test_page_space);

            imageView1.setImageResource(R.drawable.solar_system);
            imageView2.setImageResource(R.drawable.space_technology);
            imageView3.setImageResource(R.drawable.comet);
            textViewA.setText(R.string.our_solar_sytem);
            textViewB.setText(R.string.apallo_lander);
            textViewC.setText(R.string.hailey_comet);
            imageGameView.setImageResource(R.drawable.space_game);
            imageGameView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    String str = "Card Game";
                    Intent intent = new Intent(Data.this, Games.class);
                    intent.putExtra("message_key", str);
                    startActivity(intent);
                }
            });
            if(!checkbox1Value){
                imageView1.setVisibility(View.GONE);
                textViewA.setVisibility(View.GONE);
            }
            if (!checkbox2Value) {
                    imageView2.setVisibility(View.GONE);
                    textViewB.setVisibility(View.GONE);
                }

            if (!checkbox3Value) {
                imageView3.setVisibility(View.GONE);
                textViewC.setVisibility(View.GONE);
            }

        }
        else if ("Nature".equals(str))
        {
            testPage.setText(R.string.test_page_nature);
            imageView1.setImageResource(R.drawable.trees);
            imageView2.setImageResource(R.drawable.flowers);
            imageView3.setImageResource(R.drawable.seasons);
            textViewA.setText(R.string.mighty_oak);
            textViewB.setText(R.string.water_lily);
            textViewC.setText(R.string.jack_frost);
            if(!checkbox4Value){
                imageView1.setVisibility(View.GONE);
                textViewA.setVisibility(View.GONE);
            }
            if (!checkbox5Value) {
                imageView2.setVisibility(View.GONE);
                textViewB.setVisibility(View.GONE);
            }

            if (!checkbox6Value) {
                imageView3.setVisibility(View.GONE);
                textViewC.setVisibility(View.GONE);
            }
        }
        else if ("Animals".equals(str))
        {
            testPage.setText(R.string.test_page_animals);
            imageView1.setImageResource(R.drawable.mammals);
            imageView2.setImageResource(R.drawable.reptiles);
            imageView3.setImageResource(R.drawable.birds);
            textViewA.setText(R.string.mountain_moose);
            textViewB.setText(R.string.gator_croc);
            textViewC.setText(R.string.blue_jay);
            if(!checkbox7Value){
                imageView1.setVisibility(View.GONE);
                textViewA.setVisibility(View.GONE);
            }
            if (!checkbox8Value) {
                imageView2.setVisibility(View.GONE);
                textViewB.setVisibility(View.GONE);
            }

            if (!checkbox9Value) {
                imageView3.setVisibility(View.GONE);
                textViewC.setVisibility(View.GONE);
            }
        }

        else if ("Technology".equals(str))
        {
            testPage.setText(R.string.test_page_technology);
            imageView1.setImageResource(R.drawable.ai);
            imageView2.setImageResource(R.drawable.robotics);
            imageView3.setImageResource(R.drawable.coding);
            textViewA.setText(R.string.artificial_intel);
            textViewB.setText(R.string.bender_bending_rodriguez);
            textViewC.setText(R.string.android_studio_sucks);
            if(!checkbox10Value){
                imageView1.setVisibility(View.GONE);
                textViewA.setVisibility(View.GONE);
            }
            if (!checkbox11Value) {
                imageView2.setVisibility(View.GONE);
                textViewB.setVisibility(View.GONE);
            }

            if (!checkbox12Value) {
                imageView3.setVisibility(View.GONE);
                textViewC.setVisibility(View.GONE);
            }
        }
        else if ("History".equals(str))
        {
            testPage.setText(R.string.test_page_history);
            imageView1.setImageResource(R.drawable.american_history);
            imageView2.setImageResource(R.drawable.art_history);
            imageView3.setImageResource(R.drawable.music_history);
            textViewA.setText(R.string.we_the_people);
            textViewB.setText(R.string.mikey_leo_donny_ralf);
            textViewC.setText(R.string.wood_stock);
            if(!checkbox13Value){
                imageView1.setVisibility(View.GONE);
                textViewA.setVisibility(View.GONE);
            }
            if (!checkbox14Value) {
                imageView2.setVisibility(View.GONE);
                textViewB.setVisibility(View.GONE);
            }

            if (!checkbox15Value) {
                imageView3.setVisibility(View.GONE);
                textViewC.setVisibility(View.GONE);
            }
        }

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        textViewA.setOnClickListener(this);
        textViewB.setOnClickListener(this);
        textViewC.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view){



        if (view.getId() == R.id.imageView1) {
            choice = textViewA.getText().toString();
        } else if (view.getId() == R.id.imageView2) {
            choice = textViewB.getText().toString();
        } else if (view.getId() == R.id.imageView3) {
            choice = textViewC.getText().toString();
        } else if (view.getId() == R.id.textViewA) {
            choice = textViewA.getText().toString();
        } else if (view.getId() == R.id.textViewB) {
            choice = textViewB.getText().toString();
        } else if (view.getId() == R.id.textViewC) {
            choice = textViewC.getText().toString();
        }

        Intent intent = new Intent(Data.this, FactsList.class);
        intent.putExtra("choice_key", choice);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}

