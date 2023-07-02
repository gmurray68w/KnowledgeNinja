package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FactsList  extends AppCompatActivity {

    List<Fact> factList;
    EditText editTextSearch;
    ImageView imageViewSearch;
    Button informationButton;
    FactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts_list);

        editTextSearch = findViewById(R.id.editTextSearch);
        imageViewSearch = findViewById(R.id.imageViewSearch);
        informationButton = findViewById(R.id.buttonInformationPage);

        imageViewSearch.setOnClickListener(view -> {
            String query = editTextSearch.getText().toString();
            performSearch(query);
        });

        Intent intent = getIntent();
        String choice = intent.getStringExtra("choice_key");
        editTextSearch.setText(choice);


        factList = new ArrayList<>();
        AddFacts();


        adapter = new FactAdapter(factList, this);
        RecyclerView rv = findViewById(R.id.recyclerviewFacts);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        if(editTextSearch!=null){
            String query = editTextSearch.getText().toString();
            performSearch(query);
        }


        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FactsList.this, InformationActivity.class));
            }
        });
    }

    private void performSearch(String query) {
        List<Fact> searchResults = new ArrayList<>();

        for (Fact fact : factList){
            if(fact.getTopic().toLowerCase().contains(query.toLowerCase())
            || fact.getSubTopic().toLowerCase().contains(query.toLowerCase())
            || fact.getFactName().toLowerCase().contains(query.toLowerCase())){
                searchResults.add(fact);
            }
        }
        adapter.updateList(searchResults);
    }

    private void AddFacts() {

        //Planet Facts
        Fact factMercury = new Fact("Space","Solar System", "Mercury", R.drawable.mercury, R.string.mercury_fact_1);
        factList.add(factMercury);
        Fact factVenus = new Fact("Space","Solar System", "Venus", R.drawable.venus, R.string.venus_fact_1);
        factList.add(factVenus);
        Fact factEarth = new Fact("Space","Solar System", "Earth", R.drawable.earthtwo, R.string.earth_fact_1);
        factList.add(factEarth);
        Fact factMars = new Fact("Space","Solar System", "Mars", R.drawable.mars, R.string.mars_fact_1);
        factList.add(factMars);
        Fact factJupiter = new Fact("Space","Solar System", "Jupiter", R.drawable.jupiter, R.string.jupiter_fact_1);
        factList.add(factJupiter);
        Fact factSaturn = new Fact("Space","Solar System", "Saturn", R.drawable.saturn, R.string.saturn_fact_1);
        factList.add(factSaturn);
        Fact factUranus = new Fact("Space","Solar System", "Uranus", R.drawable.uranus, R.string.uranus_fact_1);
        factList.add(factUranus);
        Fact factNeptune = new Fact("Space","Solar System", "Neptune", R.drawable.neptune, R.string.neptune_fact_1);
        factList.add(factNeptune);





        // Nature Facts
        //Trees
        Fact factTreeOak = new Fact("Nature", "Trees", "Oak Tree", R.drawable.oaktree, R.string.oak_tree_fact);
        factList.add(factTreeOak);
        Fact factTreeMaple = new Fact("Nature", "Trees", "Maple Tree", R.drawable.mapletree, R.string.maple_tree_fact);
        factList.add(factTreeMaple);
        Fact factTreePine = new Fact("Nature", "Trees", "Pine Tree", R.drawable.pinetree, R.string.pine_tree_fact);
        factList.add(factTreePine);

        //Flowers
        Fact factFlowerRose = new Fact("Nature", "Flowers", "Rose Flower", R.drawable.roseflower, R.string.rose_flower_fact);
        factList.add(factFlowerRose);
        Fact factFlowerSunflower = new Fact("Nature", "Flowers", "Sunflower", R.drawable.sunflower, R.string.sunflower_fact);
        factList.add(factFlowerSunflower);
        Fact factFlowerTulip = new Fact("Nature", "Flowers", "Tulip", R.drawable.tulipflower, R.string.tulip_fact);
        factList.add(factFlowerTulip);

        //Seasons
        Fact factSeasonSpring = new Fact("Nature", "Seasons", "Spring Season", R.drawable.springscene, R.string.spring_season_fact);
        factList.add(factSeasonSpring);
        Fact factSeasonSummer = new Fact("Nature", "Seasons", "Summer Season", R.drawable.summerscene, R.string.summer_season_fact);
        factList.add(factSeasonSummer);
        Fact factSeasonAutumn = new Fact("Nature", "Seasons", "Autumn Season", R.drawable.autumnscene, R.string.autumn_season_fact);
        factList.add(factSeasonAutumn);
        Fact factSeasonWinter = new Fact("Nature", "Seasons", "Winter Season", R.drawable.winterscene, R.string.winter_season_fact);
        factList.add(factSeasonAutumn);


        //Animal facts


        //Mammals facts
        Fact factLion = new Fact("Animals","Mammals", "Lion", R.drawable.lion, R.string.lion_fact_1);
        factList.add(factLion);
        Fact factElephant = new Fact("Animals","Mammals", "Elephant", R.drawable.elephant, R.string.elephant_fact_1);
        factList.add(factElephant);
        Fact factCheetah = new Fact("Animals","Mammals", "Cheetah", R.drawable.cheetah,R.string.cheetah_fact_1);
        factList.add(factCheetah);
        Fact factDolphin = new Fact("Animals","Mammals", "Dolphin", R.drawable.dolphin, R.string.dolphin_fact_1);
        factList.add(factDolphin);

        //Birds
        Fact factBaldEagle = new Fact("Animals","Birds", "Bald Eagle", R.drawable.baldeagle, R.string.bald_eagle_fact_1);
        factList.add(factBaldEagle);
        Fact factOwl = new Fact("Animals","Birds", "Barn Owl", R.drawable.owl, R.string.owl_fact);
        factList.add(factOwl);
        Fact factRedTailedHawk = new Fact("Animals","Birds", "Red Tail Hawk", R.drawable.redtailedhawk, R.string.rthawk_fact);
        factList.add(factRedTailedHawk);
        Fact factHummingbird = new Fact("Animals","Birds", "Hummingbird", R.drawable.hummingbird, R.string.hummingbird_fact);
        factList.add(factHummingbird);

        //Reptile

        Fact factSnake = new Fact("Animals","Reptiles", "Snake", R.drawable.snake, R.string.snake_fact);
        factList.add(factSnake);
        Fact factLizard = new Fact("Animals","Reptiles", "Lizard", R.drawable.lizard, R.string.lizard_fact);
        factList.add(factLizard);
        Fact factTurtle = new Fact("Animals","Reptiles", "Turtle", R.drawable.turtle, R.string.turtle_fact);
        factList.add(factTurtle);

    }
}