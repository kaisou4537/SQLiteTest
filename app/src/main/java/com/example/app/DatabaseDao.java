package com.example.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaisou4537 on 2014/02/09.
 */
public class DatabaseDao {
    private static final String TABLE_NAME = "data";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_MEMO = "memo";
    private static final String COLUMN_PRIORITY = "priority";
    private static final String[] COLUMNS =
            {COLUMN_ID, COLUMN_MEMO, COLUMN_PRIORITY};

    private SQLiteDatabase db;

    public DatabaseDao(SQLiteDatabase db){
        this.db = db;
    }

    public long insert(DBData dbData){
        ContentValues values = new ContentValues();
        values.put(COLUMN_MEMO, dbData.getMemo());
        values.put(COLUMN_PRIORITY, dbData.getPriority());
        return db.insert(TABLE_NAME, null, values);
    }

    public int update(DBData dbData){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, dbData.getId());
        values.put(COLUMN_MEMO, dbData.getMemo());
        values.put(COLUMN_PRIORITY, dbData.getPriority());
        String whereClause = "id = " + dbData.getId();
        return db.update(TABLE_NAME, values, whereClause, null);
    }

    public List<DBData> findAll(){
        List<DBData> dbDataList = new ArrayList<DBData>();
        Cursor cursor =
                db.query(TABLE_NAME, COLUMNS, null, null, null, null, COLUMN_ID);
        while(cursor.moveToNext()){
            DBData dbData = new DBData();
            dbData.setId(cursor.getInt(0));
            dbData.setMemo(cursor.getString(1));
            dbData.setPriority(cursor.getInt(2));
            dbDataList.add(dbData);
        }
        return dbDataList;
    }

    public DBData findById(int id){
        String selection = "id = " + id;
        Cursor cursor =
                db.query(TABLE_NAME, COLUMNS, selection, null, null, null, null);
        while(cursor.moveToNext()){
            DBData dbData = new DBData();
            dbData.setId(cursor.getInt(0));
            dbData.setMemo(cursor.getString(1));
            dbData.setPriority(cursor.getInt(2));
            return dbData;
        }
        return null;
    }

    public int delete(int id){
        return db.delete(TABLE_NAME, "id = " + id, null);
    }

}
