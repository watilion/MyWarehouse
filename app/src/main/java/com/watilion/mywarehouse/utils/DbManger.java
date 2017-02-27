package com.watilion.mywarehouse.utils;
//数据库主要工具类

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by watilion on 2017/2/27 0027.
 */

public class DbManger {
    private static MySqliteHelper helper;
    public static MySqliteHelper getIntace(Context context){
        if(helper==null){
            helper=new MySqliteHelper(context);
        }
        return helper;
    }
    public static void execSQL(SQLiteDatabase db,String sql){
        if(db!=null){
            if(sql!=null&&"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }
}
