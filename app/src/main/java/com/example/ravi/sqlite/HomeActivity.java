package com.example.ravi.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ravi on 16-10-2016.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
   DatabaseHelper databaseHelper=null;
    TextView tvRet;
    EditText etEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvRet = (TextView) findViewById(R.id.tvRet);
        etEmail = (EditText) findViewById(R.id.etEmail);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        tvRet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


           String email=etEmail.getText().toString().trim();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from Student where studEmail='"+email+"'",null);
                     if (cursor.moveToFirst())
                     {

                         do {

                             String studName = cursor.getString(cursor.getColumnIndex("studName"));
                             Toast.makeText(getApplicationContext(),"Name  ::/n"+studName,Toast.LENGTH_SHORT).show();

                         }while (cursor.moveToNext());
                     }




    }
}
