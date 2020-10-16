package com.example.quotestakingmvvm.utilities;

import com.example.quotestakingmvvm.data.FakeDatabase;
import com.example.quotestakingmvvm.data.FakeQuoteDao;
import com.example.quotestakingmvvm.data.QuoteRepository;
import com.example.quotestakingmvvm.ui.quotes.QuotesViewModelFactory;

// Singleton #7
public class InjectorUtils {

    /**
     * 1. provide dependency rather than create one in user class
     * 2. we can modify any change in this method; rather than change in every dependencies
     */
    public static QuotesViewModelFactory provideQuotesViewModelFactory() {
        FakeQuoteDao dao = FakeDatabase.getInstance().getDao();
        QuoteRepository repository = QuoteRepository.getInstance(dao);


        return new QuotesViewModelFactory(repository);
    }
}
