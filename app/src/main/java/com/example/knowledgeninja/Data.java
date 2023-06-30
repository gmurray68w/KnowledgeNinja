package com.example.knowledgeninja;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.knowledgeninja.R;

public class Data extends AppCompatActivity
{

    TextView testPage;
    TextView textViewA;
    TextView textViewB;
    TextView textViewC;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_page);

        testPage = findViewById(R.id.testTextView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        textViewA = findViewById(R.id.textViewA);
        textViewB = findViewById(R.id.textViewB);
        textViewC = findViewById(R.id.textViewC);

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
        }
    }
}

