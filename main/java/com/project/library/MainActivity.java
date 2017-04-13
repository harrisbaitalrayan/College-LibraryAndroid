package com.project.library;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
