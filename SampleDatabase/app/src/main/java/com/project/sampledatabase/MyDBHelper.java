package com.project.sampledatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public static String DBNAME = "dbtest.db";
    public static int VERSION = 1;

    String tableName = "dbtable1";

    public MyDBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String string = "create table if not exists "+tableName
                + "("
                + "_id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + "age integer, "
                + "mobile text"
                + ")" ;
        sqLiteDatabase.execSQL(string);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (newVersion > 1) {
            String str = "DROP TABLE IF EXISTS " + tableName;
            sqLiteDatabase.execSQL(str);
        }
    }
}
