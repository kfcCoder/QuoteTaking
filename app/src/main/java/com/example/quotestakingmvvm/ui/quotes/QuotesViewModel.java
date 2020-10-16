package com.example.quotestakingmvvm.ui.quotes;

import android.app.Application;
import android.util.Log;
import android.widget.EditText;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.quotestakingmvvm.data.Quote;
import com.example.quotestakingmvvm.data.QuoteRepository;
import com.example.quotestakingmvvm.databinding.ActivityMainBinding;

import java.util.List;

/** #5
 * 有參構造式(依賴QuoteRepository)
 */
public class QuotesViewModel extends ViewModel {
    private QuoteRepository quoteRepository;

    public QuotesViewModel(QuoteRepository repository) {
        this.quoteRepository = repository;
    }

    public LiveData<List<Quote>> getQuotes() {
        return quoteRepository.getQuotes();
    }

    public void addQuotes(Quote quote) {
        quoteRepository.addQuotes(quote);
    }


}
