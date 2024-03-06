package com.example.todoapp.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * to create an open a file SQLite for the database
 * @author Quentin Le Lan
 */
public abstract class DAOBase {

    /**
     * the version of the base
     */
    protected final static int VERSION = 2;
    /**
     * the name of the file
     */
    protected final static String NOM = "database.db";

    /**
     * the dataBase
     */
    protected SQLiteDatabase mDb = null;

    /**
     * the dataBase Handler
     */
    protected DatabaseHandler mHandler = null;

    /**
     * create the dataBase
     * @param pContext the context
     */
    public DAOBase(Context pContext) {
        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
    }

    /**
     * open the dataBase
     * @return the dataBase
     */
    public SQLiteDatabase open() {
        mDb = mHandler.getWritableDatabase();
        return mDb;
    }

    /**
     * for close the dataBase
     */
    public void close() {
        mDb.close();
    }

    /**
     * the getter of the dataBase
     * @return the dataBase
     */
    public SQLiteDatabase getDb() {
        return mDb;
    }
}

