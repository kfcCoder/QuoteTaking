package com.example.quotestakingmvvm.ui.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.example.quotestakingmvvm.R;
import com.example.quotestakingmvvm.data.Quote;
import com.example.quotestakingmvvm.databinding.ActivityMainBinding;
import com.example.quotestakingmvvm.utilities.InjectorUtils;

import java.util.List;

/**
 * TODO
 * 1. use dataBinding
 * 2. ROOM persistence library
 * */
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    QuotesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        QuotesViewModelFactory factory = InjectorUtils.provideQuotesViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel.class);

        viewModel.getQuotes().observe(this, new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                StringBuilder sb = new StringBuilder();
                for(Quote quote : quotes) {
                    sb.append(quote.toString() + "\n");
                }
                binding.textViewQuotes.setText(sb.toString());
            }
        });

        binding.setMain(this);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);

    }

    public void addQuote() {
        String quotoText = binding.editTextQuote.getText().toString();
        String author = binding.editTextAuthor.getText().toString();

        Quote quote = new Quote(quotoText, author);
        viewModel.addQuotes(quote);

        binding.editTextQuote.setText("");
        binding.editTextAuthor.setText("");
    }
}