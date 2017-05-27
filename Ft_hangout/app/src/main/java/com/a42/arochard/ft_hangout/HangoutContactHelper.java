package com.a42.arochard.ft_hangout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arochard on 5/27/17.
 */

public class HangoutContactHelper extends SQLiteOpenHelper {


    public HangoutContactHelper(Context context)
    {
        super(context, HangoutContract.DATABASE_NAME, null, HangoutContract.DATABASE_VERSION);
    }

    //Method is called during creation of database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(HangoutContract.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old, int newV)
    {
        db.execSQL(HangoutContract.SQL_DELETE_TABLE);
        onCreate(db);
    }
}
