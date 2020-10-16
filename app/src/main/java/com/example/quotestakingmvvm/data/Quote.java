package com.example.quotestakingmvvm.data;

// #1
public class Quote {
    private String quoteText;
    private String author;

    public Quote(String quoteText, String author) {
        this.quoteText = quoteText;
        this.author = author;
    }

    @Override
    public String toString() {
        return quoteText + " - " + author;
    }
}
