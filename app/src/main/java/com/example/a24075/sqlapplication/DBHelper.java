package com.example.a24075.sqlapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class DBHelper extends SQLiteOpenHelper {
    //数据库名，表名
    private static final String  DB_NAME = "stu.db";
    private static final String  TBL_NAME = "stuTb1";
    //创建表语句
    private static final String CREATETBL="CREATE TABLE "+"stuTb1(_id INTEGER DEFAULT '1' NOT" + " NULL PRIMARY KEY AUTOINCREMENT,name TEXT , hobby TEXT )";

    //SQLiteDatabase实例
    private SQLiteDatabase db;
    //构造方法
    public DBHelper (Context context) {
        super(context, DB_NAME, null, 2);
        System.out.printf("创建数据库");
    }

    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db = db;
        db.execSQL(CREATETBL);
        System.out.printf("创建表");
    }


    //插入方法
    public void insert(ContentValues values) {
        //获得sQLiteDataBase实例
        SQLiteDatabase db = getWritableDatabase();
        //插入
        db.insert(TBL_NAME, null, values);
        db.close();
        System.out.printf("数据库插入操作");//查询方法
    }
    //查询
    public Cursor query() {
        System.out.printf("数据库查询方法");//获得sQLiteDataBase实例
        SQLiteDatabase db = getWritableDatabase();
        //查询获得cursor
        Cursor c = db.query(TBL_NAME,null,null,null,null,null,null);
        return c;
    }

    //删除方法
    public void de1(int id) {
        System.out.printf("数据库删除方法");
        if (db == null) {
            //获得sQLiteDataBase实例
            SQLiteDatabase db = getWritableDatabase();
            //删除
            db.delete(TBL_NAME, "_id=?", new String[]{String.valueOf(id)});
        }
    }
    //关闭数据库
    public void close() {
        System.out.printf("数据库删除方法");
        if (db != null) {
            db.close();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
    }





}
