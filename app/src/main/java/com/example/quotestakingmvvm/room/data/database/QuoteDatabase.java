package com.example.quotestakingmvvm.room.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quotestakingmvvm.room.data.dao.QuoteDao;
import com.example.quotestakingmvvm.room.data.entity.QuoteEntity;

/**
 * Singleton
 */
@Database(entities = {QuoteEntity.class}, version = 1)
public abstract class QuoteDatabase extends RoomDatabase {
    private static QuoteDatabase INSTANCE;

    public static QuoteDatabase getInstance(Context context) {
        if(INSTANCE == null) {
            synchronized (QuoteDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), QuoteDatabase.class, "quote_database")
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * @return QuoteDao
     */
    public abstract QuoteDao getQuoteDao();

}
