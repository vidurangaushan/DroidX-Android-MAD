package com.example.droidx_mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {

    private  static  final  int VERSION = 1;
    private static final String DB_NAME="ServiceL";
    private static final String TABLE_NAME ="Payment";

    //Column Name
    private static final String ID = "id";
    private static final String NAME= "name";
    private static final String AMOUNT = "amount";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    public DbHandler(@Nullable Context context) {

        super(context, DB_NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = " CREATE TABLE " + TABLE_NAME+" "+
                "("
                +ID+ " INTEGER PRIMARY KEY   AUTOINCREMENT,"
                +NAME+" TEXT,"
                +AMOUNT+" TEXT,"
                +STARTED+" TEXT,"
                +FINISHED+" TEXT" +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        //Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        //Create table again
        onCreate(db);
    }

    //add
    public void Enterpay(Droidmodle droidmodle){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,droidmodle.getName());
        contentValues.put(AMOUNT, droidmodle.getAmount());
        contentValues.put(STARTED,droidmodle.getStarted());
        contentValues.put(FINISHED,droidmodle.getFinished());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //close database
        sqLiteDatabase.close();
    }
}
