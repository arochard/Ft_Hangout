package com.a42.arochard.ft_hangout;

import android.provider.BaseColumns;

/**
 * Created by arochard on 5/27/17.
 */

public final class HangoutContract {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contact.db";

    private HangoutContract(){}

    /** Class define Contact table */
    public static class ContactTable implements BaseColumns
    {
        public static final String TABLE_NAME = "contact";

        public static final String COLUMN_FIRSTNAME = "firstName";
        public static final String COLUMN_LASTNAME = "lastName";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_ADRESS = "adress";
        public static final String COLUMN_MAIL = "mail";
        public static final String COLUMN_PATH_IMG = "imgPath"

    }

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + ContactTable.TABLE_NAME + " (" +
                    ContactTable._ID + " INTEGER PRIMARY KEY," +
                    ContactTable.COLUMN_FIRSTNAME + " TEXT," +
                    ContactTable.COLUMN_LASTNAME + " TEXT," +
                    ContactTable.COLUMN_PHONE + " TEXT," +
                    ContactTable.COLUMN_ADRESS + " TEXT," +
                    ContactTable.COLUMN_MAIL + " TEXT," +
                    ContactTable.COLUMN_PATH_IMG + " TEXT)";

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + ContactTable.TABLE_NAME;

}
