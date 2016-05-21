package com.example.cristobal.i_lender_u;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by cristobal on 5/18/16.
 */
public class LendDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;

    private static final String CREATE_QUERY=
            "CREATE TABLE"+User.NewUserInfo.TABLE_NAME+
                    "("+User.NewUserInfo.USER_NAME+" TEXT, "+
                         User.NewUserInfo.USER_WHO+" TEXT);";

    public LendDB (Context context){
        //Constructor de la Clase padre (SQLiteOpenHelper)
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        //Log para el Verbox de la Terminal
        Log.e("DATABASE OPERATIONS","Datebase Created / opend");
    }//Builder

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);

        Log.e("DATABASE OPERATIONS", "Table created");
    }

    public void addInformation(String name, String who,SQLiteDatabase db){
        //
        ContentValues contentValues = new ContentValues();


        contentValues.put(User.NewUserInfo.USER_NAME,name);
        contentValues.put(User.NewUserInfo.USER_WHO,who);

        //Tiene un metodó que te inserta en la DataBase
        db.insert(User.NewUserInfo.TABLE_NAME, null, contentValues);

        Log.e("DATABASE OPERATIONS", "One Row inserted...");

    }//addInformation

    public boolean insertData(String name, String who){
        //

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(User.NewUserInfo.USER_NAME, name);
        contentValues.put(User.NewUserInfo.USER_WHO, who);

        //Tiene un metodó que te inserta en la DataBase


        Log.e("DATABASE OPERATIONS", "One Row inserted...");
        Long result=db.insert(User.NewUserInfo.TABLE_NAME, null, contentValues);

        if(result==-1){
            return false;
        }
        return true;
    }

    public Cursor getInfo(SQLiteDatabase db){
        Cursor cursor;
        String[] projections= {User.NewUserInfo.USER_NAME,User.NewUserInfo.USER_WHO};

        cursor=db.query(User.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
