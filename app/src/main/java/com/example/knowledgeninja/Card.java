package com.example.knowledgeninja;

public class Card
{
    private int imageResId; //ID resource of the cards image
    private boolean isFlipped; // Tracks if card was flipped or not
    private boolean isMatched; //tracks if card is a match or not

    public Card(int imageResId)
    {
        this.imageResId = imageResId;
        this.isFlipped = false;
        this.isMatched = false;
    }

    public int getImageResId()
    {
        return imageResId;
    }

    public boolean isFlipped()
    {
        return isFlipped;
    }

    public void setFlipped(boolean flipped)
    {
        isFlipped = flipped;
    }

    public boolean isMatched()
    {
        return isMatched;
    }

    public void setMatched(boolean matched)
    {
        isMatched = matched;
    }
}
