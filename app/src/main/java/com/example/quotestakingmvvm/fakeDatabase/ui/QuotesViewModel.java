package com.example.quotestakingmvvm.fakeDatabase.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quotestakingmvvm.fakeDatabase.data.Quote;
import com.example.quotestakingmvvm.fakeDatabase.data.FakeRepository;

import java.util.List;

/** #5
 * 有參構造式(依賴QuoteRepository)
 */
public class QuotesViewModel extends ViewModel {
    private FakeRepository quoteRepository;

    public QuotesViewModel(FakeRepository repository) {
        this.quoteRepository = repository;
    }

    public LiveData<List<Quote>> getQuotes() {
        return quoteRepository.getQuotes();
    }

    public void addQuotes(Quote quote) {
        quoteRepository.addQuotes(quote);
    }


}
