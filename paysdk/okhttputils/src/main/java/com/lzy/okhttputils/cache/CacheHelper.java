package com.lzy.okhttputils.cache;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lzy.okhttputils.OkHttpUtils;

class CacheHelper extends SQLiteOpenHelper {

    public static final String DB_CACHE_NAME = "okhttputils_cache.db";
    public static final int DB_CACHE_VERSION = 1;
    public static final String TABLE_NAME = "cache_table";

    //表中的四个字段
    public static final String ID = "_id";
    public static final String KEY = "key";
    public static final String HEAD = "head";
    public static final String DATA = "data";
    public static final String TIME = "cachetime";

    //四条sql语句
    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + //
            ID + " INTEGER, " +//
            KEY + " text primary key not null UNIQUE ON CONFLICT REPLACE, " +//
            HEAD + " BLOB, " +//
            DATA + " BLOB, " +//
            TIME + " integer)";//

    public CacheHelper() {
        super(OkHttpUtils.getContext(), DB_CACHE_NAME, null, DB_CACHE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(SQL_CREATE_TABLE);
            //建立key的唯一索引后，方便使用 replace 语句
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion != oldVersion) {
            db.beginTransaction();
            try {
                db.execSQL(SQL_CREATE_TABLE);
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
