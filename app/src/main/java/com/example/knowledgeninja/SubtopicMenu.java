package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SubtopicMenu extends AppCompatActivity {
    TextView topicChosen;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtopic_menu);
        topicChosen = findViewById(R.id.tvTopicChosen);
        Intent intent = getIntent();
        //TODO Change on MAIN MENU
        String str = intent.getStringExtra("topic_key");
        Toast.makeText(this, "User Selected: " + str, Toast.LENGTH_LONG).show();
        topicChosen.setText(str);

        //TODO set Subtopic to correct menus
        //TODO Send chosen subtopic to Facts list
        topicChosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clicked = str.toString();
                Intent intent = new Intent(SubtopicMenu.this, FactsList.class);
                intent.putExtra("subtopic_key", clicked);
                startActivity(intent);
            }
        });
    }
}