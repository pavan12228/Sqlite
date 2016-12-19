package com.example.ravi.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Uname,Email,Password ;
    Button Signup;
     DatabaseHelper db=null;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
         db=new DatabaseHelper(getApplicationContext());

        Uname= (EditText) findViewById(R.id.Uname);
        Email= (EditText) findViewById(R.id.Email);
        Password= (EditText) findViewById(R.id.Password);
        Signup= (Button) findViewById(R.id.Signup);
        Signup.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

                switch (v.getId())
                {
                    case R.id.Signup:
                    String uname=Uname.getText().toString();
                    String email=Email.getText().toString();
                    String password=Password.getText().toString();

                    Contact c=new Contact(email,password);
                    c.setPassword(password);
                    c.setEmail(email);
                    c.setUser(uname);
                    long id  = db.insertStudentRecord(c);
                    if(id!=-1)
                    {
                        Intent i=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(this, "recored not inserted", Toast.LENGTH_SHORT).show();
                    }
                       break;



                }

    }
}
