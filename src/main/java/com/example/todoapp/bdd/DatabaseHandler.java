package com.example.todoapp.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * the dataBaseHandler for create the table Activity
 * @author  Quentin Le Lan
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    /**
     * the script of the table Activity
     */
    private String create="CREATE TABLE Activity ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "intitule TEXT," +
            "description TEXT," +
            "lieu TEXT," +
            "dateDebut TEXT," +
            "dateFin TEXT," +
            "heureDebut TEXT," +
            "heureFin TEXT," +
            "url TEXT);";

    /**
     * the constructor of the dataBaseHandler
     * @param context the context
     * @param name the name of the file
     * @param factory the CursorFactory
     * @param version the version
     */
    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Activity ;");
        onCreate(sqLiteDatabase);
    }
}
