package com.example.knowledgeninja;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.knowledgeninja.databinding.ActivityInformationBinding;

public class InformationActivity extends AppCompatActivity {

    Button nextButton, prevButton;
    TextView factText, informationTitle;
    ImageView resourceImage, nextButton1, prevButton1, playSound;
    int factInt;
    String factName, factFact;
    int imageLocation;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityInformationBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInformationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       setSupportActionBar(binding.appBarInformation.toolbar);
        binding.appBarInformation.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show();
         }
          });
        binding.appBarInformation.fab.hide();
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_information);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId= item.getItemId();
            if(itemId == R.id.nav_mercury){
                Toast.makeText(this, "Mercury Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Mercury Facts:");
                resourceImage.setImageResource(R.drawable.mercury);
                factText.setText(R.string.mercury_fact_1);
                return true;

            }else if(itemId == R.id.nav_venus){
                Toast.makeText(this, "Venus Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Venus Facts:");
                resourceImage.setImageResource(R.drawable.venus);
                factText.setText(R.string.venus_fact_1);
                return true;
            }else if(itemId == R.id.nav_earth){
                Toast.makeText(this, "Earth Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Earth Facts:");
                resourceImage.setImageResource(R.drawable.earthtwo);
                factText.setText(R.string.earth_fact_1);
          
                return true;
            }
            else if(itemId == R.id.nav_mars){
                Toast.makeText(this, "Mars Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Mars Facts:");
                resourceImage.setImageResource(R.drawable.mars);
                factText.setText(R.string.mars_fact_1);
                return true;
            }
            else if(itemId == R.id.nav_jupiter){
                Toast.makeText(this, "Jupiter Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Jupiter Facts:");
                resourceImage.setImageResource(R.drawable.jupiter);
                factText.setText(R.string.jupiter_fact_1);
                return true;
            }
            else if(itemId == R.id.nav_saturn){
                Toast.makeText(this, "Saturn Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Saturn Facts:");
                resourceImage.setImageResource(R.drawable.saturn);
                factText.setText(R.string.saturn_fact_1);
                return true;
            }
            else if(itemId == R.id.nav_uranus){
                Toast.makeText(this, "Uranus Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Uranus Facts:");
                resourceImage.setImageResource(R.drawable.uranus);
                factText.setText(R.string.uranus_fact_1);
                return true;
            }
            else if(itemId == R.id.nav_neptune){
                Toast.makeText(this, "Neptune Chosen", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                informationTitle.setText("Neptune Facts:");
                resourceImage.setImageResource(R.drawable.neptune);
                factText.setText(R.string.neptune_fact_1);
                return true;
            }
            return false;
        });
        factInt = 1;
        //Find variables
        Intent intent= getIntent();
        //Get extras from what user previously selected
        factName = intent.getStringExtra("factName_key");
        factFact = intent.getStringExtra("fact_key");
        imageLocation = intent.getIntExtra("imageLocation_key", 0);



        factText = (TextView)findViewById(R.id.textViewFactText);
        informationTitle = (TextView)findViewById(R.id.textViewInformationTitle);
        playSound= (ImageView) findViewById(R.id.imageViewPlaySound);
        resourceImage= (ImageView)findViewById(R.id.imageResource);
        nextButton1 = (ImageView) findViewById(R.id.imageViewNext);
        prevButton1 = (ImageView)findViewById(R.id.imageViewPrevious);

        //Bind from prev. selection
        informationTitle.setText(factName);
        factText.setText(factFact);
        Toast.makeText(InformationActivity.this,"Image is located at:" + imageLocation, Toast.LENGTH_LONG).show();
        resourceImage.setImageResource(imageLocation);

        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(informationTitle.getText().toString().equals("Earth Facts:")) {
                    Toast.makeText(InformationActivity.this,"EarthSelected",Toast.LENGTH_LONG).show();
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.earthfact1);
                    sound.start();
                    Toast.makeText(InformationActivity.this,"Finished playing",Toast.LENGTH_LONG).show();
                } else if (informationTitle.getText().toString() == "Mercury Facts:") {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.mercuryfact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Venus Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.venusfact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Mars Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.marsfact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Jupiter Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.jupiterfact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Uranus Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.uranusfact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Neptune Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.neptunefact1);
                    sound.start();
                }
                else if (informationTitle.getText().toString().equals("Saturn Facts:")) {
                    MediaPlayer sound = MediaPlayer.create(InformationActivity.this, R.raw.saturnfact1);
                    sound.start();
                }
            }

        });
        //Click listeners
        resourceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        nextButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factInt++;
                DisplayFact(factInt);
            }
        });
        prevButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factInt--;
                DisplayFact(factInt);
            }
        });
    }

    private void DisplayFact(int factInt) {
        if(factInt ==1){
            factText.setTextSize(30);
            factText.setText(R.string.earth_fact_1);
            resourceImage.setImageResource(R.drawable.earthtwo);
        }if(factInt == 2){
            factText.setTextSize(24);
            factText.setText(R.string.earth_fact_2);
            resourceImage.setImageResource(R.drawable.earthimage1);
        }if(factInt == 3){
            factText.setTextSize(22);
            factText.setText(R.string.earth_fact_3);
            resourceImage.setImageResource(R.drawable.earthimage2);
        }if(factInt >=4){
            resourceImage.setImageResource(R.drawable.earthimage3);
            factText.setText("More facts coming soon!");
        }if(factInt <=0){
            factText.setText("More facts coming soon!");
            resourceImage.setImageResource(R.drawable.earthimage4);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.information, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_information);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    
}