package com.example.quotestakingmvvm.data;

/**
 * #3 Singleton
 * a holder class for Dao(拿來取得Dao的class)
 */
public class FakeDatabase {
    private FakeQuoteDao quoteDao = new FakeQuoteDao();

    /**
     * Singleton part
     */
    private static FakeDatabase INSTANCE = new FakeDatabase();

    private FakeDatabase(){}

    public static FakeDatabase getInstance() {
        return INSTANCE;
    }

    /**
     * Dao holder part
     */
    public FakeQuoteDao getDao() {
        return quoteDao;
    }


}
