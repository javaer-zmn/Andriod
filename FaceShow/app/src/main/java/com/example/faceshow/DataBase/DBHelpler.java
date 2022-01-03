package com.example.faceshow.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Author zmn
 * @Version 1.0
 * @date 2022/1/3 19:41
 */

public class DBHelpler extends SQLiteOpenHelper {

    public static final String SQL =
            "create table Student(id integer primary key autoincrement, name text,age integer,height integer)";

    public DBHelpler(Context context) {
        /**构造函数
         * 上下文环境context
         * Stud.db是数据库名
         * 1是数据库版本
         */
        super(context,"Stud.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * 写创建数据库的SQL语句
         */
        db.execSQL(SQL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        /**
         * 升级调用该方法
         * 如果检测到版本升级了，系统进行调用该方法。
         * 删除原来的表再新建
         */
        db.execSQL("drop table Student");
        onCreate(db);
    }


}
