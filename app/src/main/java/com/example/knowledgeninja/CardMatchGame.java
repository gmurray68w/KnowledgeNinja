package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class CardMatchGame extends AppCompatActivity {
    private List<Card> deck;
    private List<Card> flippedCards;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_match_game);

        GridView gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                flipCard(position);
            }
        });

    }

    private void flipCard(int position)
    {
        Card card = deck.get(position);

        if (!card.isMatched())
        {
            if (!card.isFlipped())
            {
                // Flip the card
                card.setFlipped(true);
                updateCardView(position);

                // Check if two cards are flipped for comparison
                if (flippedCards.size() < 2)
                {
                    flippedCards.add(card);

                    if (flippedCards.size() == 2)
                    {
                        // Two cards are flipped, compare them
                        compareCards();
                        checkMatch();
                    }
                }
            }
            else
            {
                // Card is already flipped, do nothing
            }
        }
    }

    private void updateCardView(int position)
    {
        Card card = deck.get(position);

        // Update the card view based on the card's flipped state
        View cardView = gridView.getChildAt(position);
        ImageView imageView = cardView.findViewById(R.id.cardImageView);

        if (card.isFlipped()) {
            //Set the card image when it is flipped
            imageView.setImageResource(card.getImageResId());
        } else {
            //Set a default image for the card when it is face-down
            imageView.setImageResource(R.drawable.card_back);
        }
    }

    private void compareCards()
    {
        Card firstCard = flippedCards.get(0);
        Card secondCard = flippedCards.get(1);

        if (firstCard.getImageResId() == secondCard.getImageResId())
        {
            //Cards are a match
            firstCard.setMatched(true);
            secondCard.setMatched(true);

            //Perform any additional actions for a match

        }
        else
        {
            //Cards do not match flip them back face-down after a short delay
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
                }
            }, 1000); //Adjust the delay duration as needed
        }

        //Clear the flipped cards list
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