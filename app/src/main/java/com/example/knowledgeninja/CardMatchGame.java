package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardMatchGame extends AppCompatActivity {
    private List<Card> deck;
    private List<Card> flippedCards;
    private GridView gridView;

    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_match_game);

        gridView = findViewById(R.id.gridView);

        deck = new ArrayList<>();
        flippedCards = new ArrayList<>();

        initializeDeck();

        cardAdapter = new CardAdapter(this, deck);
        gridView.setAdapter(cardAdapter);

        Intent intent = getIntent();
        String str = intent.getStringExtra("user Selection:");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                flipCard(view, position);
            }
        });
    }

    private void initializeDeck()
    {
        deck.clear();

        flippedCards  = new ArrayList<>();

        deck.add(new Card(R.drawable.earthimage1));
        deck.add(new Card(R.drawable.earthimage1));
        deck.add(new Card(R.drawable.jupiter));
        deck.add(new Card(R.drawable.jupiter));
        deck.add(new Card(R.drawable.mars));
        deck.add(new Card(R.drawable.mars));
        deck.add(new Card(R.drawable.mercury));
        deck.add(new Card(R.drawable.mercury));
        deck.add(new Card(R.drawable.neptune));
        deck.add(new Card(R.drawable.neptune));
        deck.add(new Card(R.drawable.saturn));
        deck.add(new Card(R.drawable.saturn));
        deck.add(new Card(R.drawable.uranus));
        deck.add(new Card(R.drawable.uranus));
        deck.add(new Card(R.drawable.venus));
        deck.add(new Card(R.drawable.venus));

        Collections.shuffle(deck);
    }

    private void flipCard(View view, int position) {
        Card card = deck.get(position);

        if (!card.isMatched()) {
            if (!card.isFlipped()) {
                // Flip the card
                card.setFlipped(true);
                updateCardView(position);

                // Check if two cards are flipped for comparison
                if (flippedCards.size() < 2) {
                    flippedCards.add(card);

                    if (flippedCards.size() == 2) {
                        // Two cards are flipped, compare them
                        compareCards();
                        checkMatch();
                    }
                }
            } else {
                // Card is already flipped, do nothing
            }
        }
    }

    private void updateCardView(int position) {
        Card card = deck.get(position);

        // Update the card view based on the card's flipped state
        View cardView = gridView.getChildAt(position);
        if (cardView != null) {
            ImageView imageView = cardView.findViewById(R.id.cardImageView);
            ImageView cardBackImageView = cardView.findViewById(R.id.cardBackImageView);

            if (card.isFlipped()) {
                // Card is flipped, show the front image and hide the card back image
                imageView.setVisibility(View.VISIBLE);
                cardBackImageView.setVisibility(View.GONE);
                imageView.setImageResource(card.getImageResId());
            } else {
                // Card is face-down, show the card back image and hide the front image
                imageView.setVisibility(View.GONE);
                cardBackImageView.setVisibility(View.VISIBLE);
            }
        }
    }

    private void compareCards()
    {
        Card firstCard = flippedCards.get(0);
        Card secondCard = flippedCards.get(1);

        if (firstCard.getImageResId() == secondCard.getImageResId()) {
            // Cards are a match
            firstCard.setMatched(true);
            secondCard.setMatched(true);

            // Perform any additional actions for a match

        } else {
            // Cards do not match, flip them back face-down after a short delay
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstCard.setFlipped(false);
                    secondCard.setFlipped(false);
                    updateCardView(deck.indexOf(firstCard));
                    updateCardView(deck.indexOf(secondCard));
                }
            }, 1000); // Adjust the delay duration as needed
        }
        // Clear the flipped cards list
        flippedCards.clear();
    }

    private void checkMatch()
    {
        if (flippedCards.size() == 2)
        {
            Card firstCard = flippedCards.get(0);
            Card secondCard = flippedCards.get(1);

            if(firstCard.getImageResId() == secondCard.getImageResId())
            {
                //Card are matched
                firstCard.setMatched(true);
                secondCard.setMatched(true);

                //Add more functionality after testing

                //Clear flipped card list
                flippedCards.clear();

                //Win condition
                if (gameComplete())
                {
                    //Add functionality after testing
                }
                else
                {
                    //If cards are not a match
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable()
                    {
                        @Override
                                public void run()
                        {
                            firstCard.setFlipped(false);
                            secondCard.setFlipped(false);
                            updateCardView(deck.indexOf(firstCard));
                            updateCardView(deck.indexOf(secondCard));

                            //Clears flipped list
                            flippedCards.clear();
                        }
                    }, 1000);
                }
            }
        }
    }

    private boolean gameComplete()
    {
        for (Card card : deck)
        {
            if (!card.isMatched())
            {
                return false; //Unmatched cards game not finished
            }
        }
        return true; //All cards are matched
    }
}