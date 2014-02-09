package com.example.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kaisou4537 on 2014/02/09.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "db_data";
    private static final int DATABASE_VERSION = 1;

    // テーブル作成SQL
    private static final String CREATE_SCHEDULE_TABLE_SQL = "create table data"
            + "(id integer primary key autoincrement,"
            + "memo text not null, "
            + "priority integer default 1)";

    // テーブル削除SQL
    private static final String DROP_SCHEDULE_TABLE_SQL = "drop table if exists data";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // テーブル作成
    // 必須
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_SCHEDULE_TABLE_SQL);
    }

    // テーブルの再作成
    // 必須
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_SCHEDULE_TABLE_SQL);
        onCreate(db);
    }

}
