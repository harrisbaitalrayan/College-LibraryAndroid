package com.project.library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button btnregister;
    private dbhelper db;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        session = new SessionManager(getApplicationContext());

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.library_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                Toast.makeText(getApplicationContext(),
                        "User successfully registered.", Toast.LENGTH_SHORT).show();
            }

        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R..main, menu);

        MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.actionmenu, menu);

        if(session.isLoggedIn()){
            //   menu.add(0, MENU_LOGOUT, Menu.NONE, "Logout").setIcon(R.drawable.logout);
            inflater.inflate(R.menu.actionmenu, menu);
        }

        return super.onCreateOptionsMenu(menu);


        // return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(android.R.id.home == item.getItemId()){
            Intent homeIntent = new Intent(this, MainActivity.class);
            //homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }else if(R.menu.actionmenu == item.getItemId()){
            session.logoutUser();
        }
        return super.onOptionsItemSelected(item);
    }
}
