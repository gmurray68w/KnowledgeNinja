package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    TextView tvData;
    Button discoverMore;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        tvData = findViewById(R.id.textViewData);
        String data = getIntent().getStringExtra("data");
        tvData.setText(data);
        discoverMore = findViewById(R.id.buttonDiscover);
        discoverMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationActivity.this, FactsList.class);
                startActivity(intent);

            }
        });
    }
}