package com.example.cristobal.ilend_lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by cristobal on 5/6/16.
 */
public class DataBase extends SQLiteOpenHelper {


    //Creas la Base de Datos
    public static final String DATABASE_NAME="Books.db";

    //Creo una tabla para todos los datos
    public static final String TABLE_NAME="books_table";

    static final int DBVERSION='1';

    //Creo las columnas de la tabla
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="THING";
    public static final String COL_4="DATE";

    public DataBase(Context context) {
        super(context, "Lend", null, DBVERSION);
        SQLiteDatabase db= this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , THING TEXT, DATE TEXT ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String name, String thing, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, thing);
        contentValues.put(COL_4, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }//InsertData

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


    public boolean updateData(String id, String name, String thing, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, thing);
        contentValues.put(COL_4, date);
        db.update(TABLE_NAME,contentValues,"id = ?",new String[] {id});
        return true;
    }

    public Integer delateData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id=?",new String[] {id});
    }

    public String[] readNames(){
        String tmp1[];
        String tmp2 = "";
        String[] columns = {"Nombre"};

        Cursor cursor = this.getReadableDatabase().query("names", columns, null, null, null, null, null);
        cursor.moveToFirst();

        int name = cursor.getColumnIndex("Nombre");
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            tmp2 = tmp2 + cursor.getString(name)+"\n";
        }

        tmp1 = tmp2.split("\n");
        return tmp1;
    }
}
