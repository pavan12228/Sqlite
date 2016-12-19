package com.example.ravi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper  extends SQLiteOpenHelper
{
     SQLiteDatabase db=null;

    public  DatabaseHelper(Context context)
    {
           super(context,"GenieTechDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Student(studName Text,studEmail Text primary key,password Text) ");
             Log.e("table created","created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String query="drop table if exists Student";
             db.execSQL(query);
             onCreate(db);
    }

    public long insertStudentRecord(Contact c) {



        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
           cv.put("studName",c.getUser());
            cv.put("studEmail",c.getEmail());
             cv.put("password",c.getPassword());
             long id= db.insert("Student",null,cv);



        return id ;
    }

    public boolean loginData(Contact c) {


        boolean val = false;
        db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from  Student",null);
                 if(cursor.moveToFirst())
                 {

                  do {

                      String studNames=cursor.getString(cursor.getColumnIndex("studName"));
                      String passwords=cursor.getString(cursor.getColumnIndex("password"));


                      Log.i("email", studNames);
                      Log.i("password",passwords);

                      if (studNames.equals(c.getUser()) && passwords.equals(c.getPassword()))
                          val = true;
                      else
                          val = false;


                 } while (cursor.moveToNext());


                 }

        return val;
    }
}
