package com.example.quotestakingmvvm.fakeDatabase.utilities;

import com.example.quotestakingmvvm.fakeDatabase.data.FakeDatabase;
import com.example.quotestakingmvvm.fakeDatabase.data.FakeQuoteDao;
import com.example.quotestakingmvvm.fakeDatabase.data.FakeRepository;
import com.example.quotestakingmvvm.fakeDatabase.ui.QuotesViewModelFactory;

// Singleton #7
public class InjectorUtils {

    /**
     * 1. provide dependency rather than create one in user class
     * 2. we can modify any change in this method; rather than change in every dependencies
     */
    public static QuotesViewModelFactory provideQuotesViewModelFactory() {
        FakeQuoteDao dao = FakeDatabase.getInstance().getDao();
        FakeRepository repository = FakeRepository.getInstance(dao);


        return new QuotesViewModelFactory(repository);
    }
}
