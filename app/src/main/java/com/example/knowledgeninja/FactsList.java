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

      //  Intent intent = getIntent();
       // String str = intent.getStringExtra("subtopic_key");
        // editTextSearch.setText(str);
       // performSearch(str);
        RecyclerView rv = findViewById(R.id.recyclerviewFacts);
        factList = new ArrayList<>();
        AddFacts();


        adapter = new FactAdapter(factList, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

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


        //Animal facts
        Fact factLion = new Fact("Animals","Land", "Lion", R.drawable.lion, R.string.lion_fact_1);
        factList.add(factLion);
        Fact factElephant = new Fact("Animals","Land", "Elephant", R.drawable.elephant, R.string.elephant_fact_1);
        factList.add(factElephant);
        Fact factCheetah = new Fact("Animals","Land", "Cheetah", R.drawable.cheetah,R.string.cheetah_fact_1);
        factList.add(factCheetah);
        Fact factDolphin = new Fact("Animals","Water", "Dolphin", R.drawable.dolphin, R.string.dolphin_fact_1);
        factList.add(factDolphin);
        Fact factBaldEagle = new Fact("Animals","Air", "Bald Eagle", R.drawable.baldeagle, R.string.bald_eagle_fact_1);
        factList.add(factBaldEagle);

    }
}