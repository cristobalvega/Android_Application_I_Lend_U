package com.example.cristobal.i_lender_u;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by cristobal on 5/22/16.
 */
public class DBAdapter {

    //Columnas
    static final String ID="id";
    static final String NAME="name";
    static final String DATE="date";
    static final String WHO="who";

    //Propiedades de la Base De Datos
    static final String DBNAME="m_DB";
    static final String TBNAME="m_TB";
    static final int DBVERSION=1;

    static final String CREATE_TB="CREATE TABLE m_TB(id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "name TEXT NOT NULL, position TEXT NOT NULL);";

    //final Context context;
    SQLiteDatabase db;

    //Clase anoníma de la Base de Datos
    /*private static class DBHelper extends SQLiteDatabase{

        public DBHelper(Context context){
            super(context, DBNAME, null, DBVERSION);
        }//Constructor

        @Override
        public void onCreate(SQLiteDatabase db){

        }//onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVer, int arg2){

        }

    }//DBHelper*/

}
