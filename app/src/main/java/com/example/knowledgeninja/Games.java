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
    ImageView game1, gameView2, gameView3, gameView4;
    TextView gameText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        game1 = findViewById(R.id.game1);
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
            gameText.setText(R.string.space_game_tile);
            game1.setImageResource(R.drawable.space_card_game);
            game1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent1 = new Intent(Games.this, CardMatchGame.class);
                    intent1.putExtra("User Selection:", "Planet Card Match");
                    startActivity(intent1);
                }
            });
        }
    }
}