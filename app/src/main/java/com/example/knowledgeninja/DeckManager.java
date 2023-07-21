package com.example.knowledgeninja;

import com.example.knowledgeninja.Card;
import com.example.knowledgeninja.CardMatchGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckManager
{
    private List<Card> deck;

    public DeckManager()
    {
        deck = new ArrayList<>();
    }

    public List<Card> shuffleDeck(List<Integer> cardImage)
    {
        for (Integer imageResId: cardImage)
        {
            deck.add(new Card(imageResId));
            deck.add(new Card(imageResId));
        }
        Collections.shuffle(deck);
        return deck;
    }
}
