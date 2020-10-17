package com.example.quotestakingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.quotestakingmvvm.databinding.ActivityMainBinding;
import com.example.quotestakingmvvm.room.data.dao.QuoteDao;
import com.example.quotestakingmvvm.room.data.database.QuoteDatabase;
import com.example.quotestakingmvvm.room.data.entity.QuoteEntity;
import com.example.quotestakingmvvm.room.viewModel.QuoteEntityViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    //private QuotesViewModel mQuotesViewmodel;
    private QuoteDao mQuoteDao;
    private QuoteEntityViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        /* for FakeDatabase
        QuotesViewModelFactory factory = InjectorUtils.provideQuotesViewModelFactory();
        mQuotesViewmodel = ViewModelProviders.of(this, factory).get(QuotesViewModel.class);

        mQuotesViewmodel.getQuotes().observe(this, new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                StringBuilder sb = new StringBuilder();
                for(Quote quote : quotes) {
                    sb.append(quote.toString() + "\n");
                }
                mBinding.textViewQuotes.setText(sb.toString());
            }
        });

        mBinding.setMain(this);
        mBinding.setQuotesViewmodel(mViewmodel);
        mBinding.setLifecycleOwner(this);
        */

        mViewModel = ViewModelProviders.of(this).get(QuoteEntityViewModel.class);

        mQuoteDao = QuoteDatabase.getInstance(this).getQuoteDao();


        LiveData<List<QuoteEntity>> allQuotesLive = mQuoteDao.getAllQuotesLive();
        allQuotesLive.observe(this, new Observer<List<QuoteEntity>>() {
            @Override
            public void onChanged(List<QuoteEntity> quoteEntities) {
                StringBuilder sb = new StringBuilder();
                /*for(QuoteEntity entity : quoteEntities) { // 會有[]顯示
                    sb.append(quoteEntities.toString() + "\n");
                }*/

                for(int i=0; i<quoteEntities.size(); i++) {
                    sb.append(quoteEntities.get(i).toString() + "\n");
                }
                mBinding.textViewQuotes.setText(sb.toString());
            }
        });


        mBinding.buttonAddQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String quotoText = mBinding.editTextQuote.getText().toString();
                String author = mBinding.editTextAuthor.getText().toString();

                QuoteEntity entity = new QuoteEntity(quotoText, author);
                mViewModel.insertQuotes(entity);

                mBinding.editTextQuote.setText("");
                mBinding.editTextAuthor.setText("");
            }
        });

        mBinding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.deleteAllQuotes();
            }
        });



    }

    /* for FakeDatabase
    public void addQuote() {
        String quotoText = mBinding.editTextQuote.getText().toString();
        String author = mBinding.editTextAuthor.getText().toString();

        Quote quote = new Quote(quotoText, author);
        mViewmodel.addQuotes(quote);

        mBinding.editTextQuote.setText("");
        mBinding.editTextAuthor.setText("");
    }*/

}