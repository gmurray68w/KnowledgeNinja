package com.example.knowledgeninja;

public class Card {
    private final int imageResId;
    private boolean isFlipped;
    private boolean isMatched;

    public Card(int imageResId) {
        this.imageResId = imageResId;
        this.isFlipped = false;
        this.isMatched = false;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
}
