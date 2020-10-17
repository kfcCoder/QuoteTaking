package com.example.quotestakingmvvm.room.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quotestakingmvvm.room.data.entity.QuoteEntity;

import java.util.List;

@Dao
public interface QuoteDao {
    @Insert
    void insertQuote(QuoteEntity... quotes);

    @Delete
    void deleteQuotes(QuoteEntity... quotes);

    @Query("DELETE FROM quotes")
    void deleteAllQuotes();

    @Query("SELECT * FROM quotes ORDER BY id DESC" )
    LiveData<List<QuoteEntity>> getAllQuotesLive();
    //List<QuoteEntity> getAllQuotes();

    @Update
    void updateQuotes(QuoteEntity... quotes);
}
