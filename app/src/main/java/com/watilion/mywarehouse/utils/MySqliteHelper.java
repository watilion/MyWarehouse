package com.watilion.mywarehouse.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by watil on 2017/2/27 0027.
 */

public class MySqliteHelper extends SQLiteOpenHelper {
    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySqliteHelper(Context context) {
        super(context, Constant.DATABASE_NAME, null, Constant.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + Constant.TABLE_NAME + "(" + Constant._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Constant.NAME + " varchar(10)," + Constant.MODELNUMBER + " Integer," + Constant.NUMBER + " Integer," + Constant.LOCATION + " verchar)";
        db.execSQL(sql);
//        Log.i("tag", "-----创建成功-----");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
//        Log.i("tag", "-----onopen成功-----");
        super.onOpen(db);
    }
}
