package com.project.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    private Button btnregister;
    private dbhelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister = (Button) findViewById(R.id.button5);
        db  = new dbhelper(getApplicationContext());
        btnregister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                String user_id = ((EditText) findViewById(R.id.editText)).getText().toString();
                String user_name = "";

                String user_email = ((EditText) findViewById(R.id.editText3)).getText().toString();
                String user_address = ((EditText) findViewById(R.id.editText2)).getText().toString();
                String user_dob = ((EditText) findViewById(R.id.editText4)).getText().toString();
                String user_mobile = ((EditText) findViewById(R.id.editText5)).getText().toString();
                String user_pwd = ((EditText) findViewById(R.id.editText7)).getText().toString();

                db.addUser(user_id,user_name,user_email,user_address,user_dob,user_mobile,user_pwd);
            }

        });



    }
}
