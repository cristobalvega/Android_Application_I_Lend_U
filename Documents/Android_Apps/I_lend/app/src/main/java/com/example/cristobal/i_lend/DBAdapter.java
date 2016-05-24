package com.example.cristobal.i_lend;

/**
 * Created by cristobal on 5/23/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter {


    //COLUMNS
    static final String ROWID="id";
    static final String NAME = "name";
    static final String POSITION = "position";

    //DB PROPERTIES
    static final String DBNAME="m_DB";
    static final String TBNAME="m_TB";
    static final int DBVERSION='1';

    static final String CREATE_TB="CREATE TABLE m_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,position TEXT NOT NULL);";

    final Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context ctx) {
        // TODO Auto-generated constructor stub

        this.c=ctx;
        helper=new DBHelper(c);
    }

    // INNER HELPER DB CLASS
    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context	) {
            super(context, DBNAME, null, DBVERSION);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TB);
            } catch (SQLException e) {
                e.printStackTrace();
            }//Try-Catch

        }//onCreate

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

            Log.w("DBAdapetr","Upgrading DB");

            db.execSQL("DROP TABLE IF EXISTS m_TB");

            onCreate(db);
        }//onUpgarde



    }//Static class

    // OPEN THE DB
    public DBAdapter openDB() {
        try
        {
            db=helper.getWritableDatabase();

        }catch(SQLException e)
        {
            Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return this;
    }//openDB


    //CLOSE THE DB
    public void close(){
        helper.close();
    }//closeDB

    //INSERT INTO TABLE
    public long add(String name,String pos){
        try {
            ContentValues cv=new ContentValues();
            cv.put(NAME, name);
            cv.put(POSITION, pos);

            return db.insert(TBNAME, ROWID, cv);

        }catch(SQLException e) {
            e.printStackTrace();
        }//try-catch

        return 0;
    }//add

    public Integer delateData(String id){
        db=helper.getWritableDatabase();
        return db.delete(TBNAME,"id=?",new String[] {id});
    }
    //GET ALL VALUES

    public Cursor getAllNames() {
        String[] columns={ROWID,NAME,POSITION};

        return db.query(TBNAME, columns, null, null, null, null, null);
    }//getAllNames

}//DBAdaper
