package com.example.quotestakingmvvm.data;

import androidx.lifecycle.LiveData;

import java.util.List;

// #4 Singleton
public class QuoteRepository {
    private FakeQuoteDao quoteDao;

    /**
     * Singleton part
     */
    private static QuoteRepository INSTANCE;

    public static QuoteRepository getInstance(FakeQuoteDao quoteDao) { // change to synchronized version for 傳入參數
        if (INSTANCE == null) {
            synchronized (QuoteRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QuoteRepository(quoteDao);
                }
            }
        }
        return INSTANCE;
    }

    private QuoteRepository(FakeQuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    /**
     * some method
     */
    public void addQuotes(Quote quote) {
        quoteDao.addQuotes(quote);
    }

    public LiveData<List<Quote>> getQuotes() {
        return quoteDao.getQuotes();
    }

}
