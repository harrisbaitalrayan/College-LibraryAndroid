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
                    borrowBook("BKM01","Social Media","English","TSAR");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image2 =  (ImageView) findViewById(R.id.imageView11);
        image2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM02","Optimizing","English","Steve");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image3 =  (ImageView) findViewById(R.id.imageView101);
        image3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM03","Coding","English","Mark");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image4 =  (ImageView) findViewById(R.id.imageView102);
        image4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM04","Software Dev","English","Hol");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image5 =  (ImageView) findViewById(R.id.imageView103);
        image5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM05","Solo","English","Adam");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image6 =  (ImageView) findViewById(R.id.imageView104);
        image6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM06","Privacy","English","Jan");
                }else{
                    showLoginError();
                }
            }
        });
        ImageView image7 =  (ImageView) findViewById(R.id.imageView105);
        image7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM07","Python","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image8 =  (ImageView) findViewById(R.id.imageView106);
        image8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM08","HTML","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });


        // Second ROW books


        ImageView image9 =  (ImageView) findViewById(R.id.imageView15);
        image9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM09","Kinect","English","Sam");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image10 =  (ImageView) findViewById(R.id.imageView14);
        image10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM10","PERL","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image11 =  (ImageView) findViewById(R.id.imageView13);
        image11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM11","Google App","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image12 =  (ImageView) findViewById(R.id.imageView131);
        image12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM12","Passionate","English","Siri");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image13 =  (ImageView) findViewById(R.id.imageView132);
        image13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM13","Nanoscale","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image14 =  (ImageView) findViewById(R.id.imageView133);
        image14.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM14","Info Tech","English","MK");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image15 =  (ImageView) findViewById(R.id.imageView134);
        image15.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM15","Science Tech","English","Joy");
                }else{
                    showLoginError();
                }
            }
        });



        // THIRD ROW BOOKS

        ImageView image16 =  (ImageView) findViewById(R.id.imageView18);
        image16.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM16","Oject Oriented","English","Ran");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image17 =  (ImageView) findViewById(R.id.imageView17);
        image17.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM17","Code","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image18 =  (ImageView) findViewById(R.id.imageView16);
        image18.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM18","Materials","English","Clove");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image19 =  (ImageView) findViewById(R.id.imageView161);
        image19.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM19","Lean Software","English","Steve");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image20 =  (ImageView) findViewById(R.id.imageView162);
        image20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM20","Fortran","English","Roman");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image21 =  (ImageView) findViewById(R.id.imageView163);
        image21.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM21","Python Biology","English","Rayes");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image22 =  (ImageView) findViewById(R.id.imageView164);
        image22.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM22","Social Media","English","Disten");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image23 =  (ImageView) findViewById(R.id.imageView165);
        image23.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM23","C++","English","Steve");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image24 =  (ImageView) findViewById(R.id.imageView166);
        image24.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM24","Coding","English","Reilly");
                }else{
                    showLoginError();
                }
            }
        });

        ImageView image25 =  (ImageView) findViewById(R.id.imageView167);
        image25.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                if(session.isLoggedIn()){
                    borrowBook("BKM25","Legal Techno","English","AJ");
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


    private void borrowBook(String bookID,String bookName,String bookLang,String bookAuth){

        final String bookID_1 = bookID;
        final String bookName_1 = bookName;
        final String bookLang_1 = bookLang;
        final String bookAuth_1 = bookAuth;

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

                db.addBorrowBook(session.getUserDetails().get(KEY_NAME),bookID_1,bookName_1,bookLang_1,bookAuth_1);
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
