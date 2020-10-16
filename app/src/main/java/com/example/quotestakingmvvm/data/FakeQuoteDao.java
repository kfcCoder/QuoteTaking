package com.example.quotestakingmvvm.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

// #2
public class FakeQuoteDao {
    private List<Quote> quoteList = new ArrayList<>();
    private MutableLiveData<List<Quote>> quotes = new MutableLiveData<>();

    public FakeQuoteDao() {
        quotes.setValue(quoteList);
    }

    public void addQuotes(Quote quote) {
        quoteList.add(quote);
        quotes.setValue(quoteList);
    }

    public LiveData<List<Quote>> getQuotes() {
        return quotes;
    }

}
