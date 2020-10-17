package com.example.quotestakingmvvm.fakeDatabase.data;

import androidx.lifecycle.LiveData;

import java.util.List;

// #4 Singleton
public class FakeRepository {
    private FakeQuoteDao fakeQuoteDao;

    /**
     * Singleton part
     * <pass dao from outside to getInstance() -> init ctor -> init member field dao>
     */
    private static FakeRepository INSTANCE;

    public static FakeRepository getInstance(FakeQuoteDao quoteDao) {
        if (INSTANCE == null) {
            synchronized (FakeRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FakeRepository(quoteDao);
                }
            }
        }
        return INSTANCE;
    }

    private FakeRepository(FakeQuoteDao quoteDao) {
        this.fakeQuoteDao = quoteDao;
    }

    /**
     * for FakeDatabase
     */
    public void addQuotes(Quote quote) {
        fakeQuoteDao.addQuotes(quote);
    }

    public LiveData<List<Quote>> getQuotes() {
        return fakeQuoteDao.getQuotes();
    }



}
