package com.example.quotestakingmvvm.fakeDatabase.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.quotestakingmvvm.fakeDatabase.data.FakeRepository;

/**
 * #6
 * ViewModelFactory is used when ViewModel needs parameters to construct
 */
public class QuotesViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private FakeRepository quoteRepository;

    public QuotesViewModelFactory(FakeRepository repository) {
        this.quoteRepository = repository;
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new QuotesViewModel(quoteRepository);
    }
}
