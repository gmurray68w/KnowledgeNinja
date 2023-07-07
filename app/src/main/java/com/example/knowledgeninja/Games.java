package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Games extends AppCompatActivity
{
    ImageView gameView1, gameView2, gameView3, gameView4;
    TextView gameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        gameView1 = findViewById(R.id.gameView1);
        gameView2 = findViewById(R.id.gameView2);
        gameView3 = findViewById(R.id.gameView3);
        gameView4 = findViewById(R.id.gameView4);
        gameText = findViewById(R.id.gameText);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        gameText.setText(str);
        Toast.makeText(this, "User Selected: " + str, Toast.LENGTH_LONG).show();

        if ("Card Game".equals(str))
        {
            gameText.setText("Space Games");
            gameView1.setImageResource(R.drawable.space_card_game);
            //gameView1.setOnClickListener(new View.OnClickListener()
            //{
            //    @Override
            //    public void onClick(View view)
            //    {
            //        Intent intent = new Intent(Games.this, CardMatchGame.class);
            //        intent.putExtra("User Selection: ", "Planet Card Match");
            //        startActivity(intent);
            //    }
            //});
        }
    }
}