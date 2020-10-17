package com.example.quotestakingmvvm.room.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quotestakingmvvm.room.data.dao.QuoteDao;
import com.example.quotestakingmvvm.room.data.database.QuoteDatabase;
import com.example.quotestakingmvvm.room.data.entity.QuoteEntity;
import com.example.quotestakingmvvm.room.repository.QuoteRepository;

public class QuoteEntityViewModel extends AndroidViewModel {
    private QuoteRepository quoteRepository;

    public QuoteEntityViewModel(@NonNull Application application) {
        super(application);
        QuoteDao quoteDao = QuoteDatabase.getInstance(application).getQuoteDao();
        quoteRepository = QuoteRepository.getInstance(quoteDao);
    }

    public void insertQuotes(QuoteEntity... quoteEntities) {
        quoteRepository.insertQuotes(quoteEntities);
    }

    public void updateQuotes(QuoteEntity... quoteEntities) {
        quoteRepository.updateQuotes(quoteEntities);
    }

    public void deleteQuotes(QuoteEntity... quoteEntities) {
        quoteRepository.deleteQuotes(quoteEntities);
    }

    public void deleteAllQuotes() {
        quoteRepository.deleteAllQuotes();
    }





}
