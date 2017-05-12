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
import android.widget.ImageView;
import android.widget.Toast;

import static com.project.library.SessionManager.KEY_NAME;

public class MainActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnRegister;
    private Button btnSearch;
    private Button btnContact;
    private Button btnBorrow;
    SessionManager session;
    AlertDialog alertDialog;
    private dbhelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.library_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db  = new dbhelper(getApplicationContext());



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



        ImageView image1 =  (ImageView) findViewById(R.id.imageView12);
        image1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook();


                }else{

                    showLoginError();


                }
            }
        });


    }


    private void showLoginError(){

        alertDialog = new AlertDialog.Builder(MainActivity.this).create();

        alertDialog.setTitle("Login validation");

        alertDialog.setMessage("Login to borrow books.");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {

                Intent i = new Intent(getApplicationContext(),
                        LoginActivity.class);

                startActivity(i);

            } });

        alertDialog.show();




    }


    private void borrowBook(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        // Setting Dialog Title
        alertDialogBuilder.setTitle("Confirm Borrow.");

        // Setting Dialog Message
        alertDialogBuilder.setMessage("Do you want to borrow this book?");

        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.delete);

        // Setting Positive "Yes" Button
        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                // Write your code here to invoke YES event
               // Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();

                //db.addBorrowBook(session.getUserDetails().get(KEY_NAME),bookID,bookName,bookLang,bookAuth);
                db.addBorrowBook(session.getUserDetails().get(KEY_NAME),"Test1","Test1","Test1","Test1");

                alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                alertDialog.setTitle("Borrow");

                alertDialog.setMessage("Book successfully borrowed by user. ");

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        alertDialog.dismiss();

                    } });

                alertDialog.show();
            }
        });

        // Setting Negative "NO" Button
        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event
                //Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialogBuilder.show();





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
        }else if("Logout".equals(item.getTitle())){
            session.logoutUser();
        }
        return super.onOptionsItemSelected(item);
    }
}
