package com.project.library;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnRegister;
    private Button btnSearch;
    private Button btnContact;
    private Button btnBorrow;
    SessionManager session;
    AlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.library_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        btnlogin = (Button) findViewById(R.id.button2);
        btnlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               /* String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }*/

                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);
                startActivity(i);
                //finish();
            }

        });

        btnRegister = (Button) findViewById(R.id.button3);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               /* String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }*/

                Intent i = new Intent(getApplicationContext(),
                        Register.class);
                startActivity(i);
                //finish();
            }

        });

        btnSearch = (Button) findViewById(R.id.button4);
        btnSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               /* String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }*/

                Intent i = new Intent(getApplicationContext(),
                        Search.class);
                startActivity(i);
                //finish();
            }

        });

        btnContact = (Button) findViewById(R.id.button6);
        btnContact.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               /* String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }*/

                Intent i = new Intent(getApplicationContext(),
                        Contact.class);
                startActivity(i);
                //finish();
            }

        });

        btnBorrow = (Button) findViewById(R.id.button);
        session = new SessionManager(getApplicationContext());
        btnBorrow.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               /* String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }*/
                if(session.isLoggedIn()){
                    Intent i = new Intent(getApplicationContext(),
                            Borrow.class);
                    startActivity(i);
                    //finish();
                }else{

                    alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                    alertDialog.setTitle("Login validation");

                    alertDialog.setMessage("Login to view Borrow screen.");

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {

                            Intent i = new Intent(getApplicationContext(),
                                    LoginActivity.class);

                            startActivity(i);

                        } });
                    alertDialog.show();
                }


            }

        });
    }
    private static final int MENU_ADD = Menu.FIRST;
    private static final int MENU_LOGOUT = Menu.FIRST + 4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R..main, menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionmenu, menu);

        //if(session.isLoggedIn()){
            menu.add(0, MENU_LOGOUT, Menu.NONE, "Logout").setIcon(R.drawable.logout);
      // }

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
        }
        return super.onOptionsItemSelected(item);
    }
}
