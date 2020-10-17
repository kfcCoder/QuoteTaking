package com.example.quotestakingmvvm.room.repository;

import android.os.AsyncTask;

import com.example.quotestakingmvvm.room.data.dao.QuoteDao;
import com.example.quotestakingmvvm.room.data.entity.QuoteEntity;

/**
 * Singleton
 */
public class QuoteRepository {
    private QuoteDao quoteDao;

    /**
     * singleton part
     */
    private static QuoteRepository INSTANCE;

    private QuoteRepository(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    public static QuoteRepository getInstance(QuoteDao quoteDao) {
        if(INSTANCE == null) {
            synchronized (QuoteRepository.class) {
                if(INSTANCE == null) {
                    INSTANCE = new QuoteRepository(quoteDao);
                }
            }
        }
        return INSTANCE;
    }


    /**
     * 增、刪、查、改
     */
    public void insertQuotes(QuoteEntity... quoteEntities) {
        new InsertAsyncTask(quoteDao).execute(quoteEntities);
    }

     public void updateQuotes(QuoteEntity... quoteEntities) {
        new UpdateAsyncTask(quoteDao).execute(quoteEntities);
    }

     public void deleteQuotes(QuoteEntity... quoteEntities) {
        new DeleteAsyncTask(quoteDao).execute(quoteEntities);
    }

     public void deleteAllQuotes() {
        new DeleteAllAsyncTask(quoteDao).execute();
    }

    static class InsertAsyncTask extends AsyncTask<QuoteEntity, Void, Void> {
        private QuoteDao quoteDao;

        public InsertAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(QuoteEntity... quoteEntities) {
            quoteDao.insertQuote(quoteEntities);
            return null;
        }
    }

    static class UpdateAsyncTask extends AsyncTask<QuoteEntity, Void, Void> {
        private QuoteDao quoteDao;

        public UpdateAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(QuoteEntity... quoteEntities) {
            quoteDao.updateQuotes(quoteEntities);
            return null;
        }
    }

    static class DeleteAsyncTask extends AsyncTask<QuoteEntity, Void, Void> {
        private QuoteDao quoteDao;

        public DeleteAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(QuoteEntity... quoteEntities) {
            quoteDao.deleteQuotes(quoteEntities);
            return null;
        }
    }

    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private QuoteDao quoteDao;

        public DeleteAllAsyncTask(QuoteDao quoteDao) {
            this.quoteDao = quoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            quoteDao.deleteAllQuotes();
            return null;
        }
    }



}
