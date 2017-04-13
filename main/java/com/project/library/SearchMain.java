package com.project.library;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import static com.project.library.SessionManager.KEY_NAME;

public class SearchMain extends AppCompatActivity {


    private dbhelper db;
    private SimpleCursorAdapter dataAdapter;
    AlertDialog alertDialog;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchmain);



        db  = new dbhelper(getApplicationContext());
                String language = getIntent().getStringExtra("language");
                String bookName = getIntent().getStringExtra("bookName");
                String author = getIntent().getStringExtra("author");

                Cursor cursor = db.getBookDetails(bookName,language,author);
                displayListView(cursor);






    }


    private void displayListView(Cursor cursor) {


        // The desired columns to be bound
        String[] columns = new String[] {
                dbhelper.BOOK_ID,
                dbhelper.BOOK_NAME,
                dbhelper.BOOK_LANG,
                dbhelper.BOOK_AUTH
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.book_id,
                R.id.book_name,
                R.id.book_language,
                R.id.book_author,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.activity_searchdetails,
                cursor,
                columns,
                to,
                0);


        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String bookID =
                        cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.BOOK_ID));

                String bookName =
                        cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.BOOK_NAME));

                String bookLang =
                        cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.BOOK_LANG));

                String bookAuth =
                        cursor.getString(cursor.getColumnIndexOrThrow(dbhelper.BOOK_AUTH));


                Toast.makeText(getApplicationContext(),
                        bookName, Toast.LENGTH_SHORT).show();

                session = new SessionManager(getApplicationContext());

                if(session.isLoggedIn()){

                    db.addBorrowBook(session.getUserDetails().get(KEY_NAME),bookID,bookName,bookLang,bookAuth);
                    alertDialog = new AlertDialog.Builder(SearchMain.this).create();

                    alertDialog.setTitle("Borrow");

                    alertDialog.setMessage("Book successfully borrowed by user. ");

                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {

                            alertDialog.dismiss();

                        } });

                    alertDialog.show();


                }else{

                    alertDialog = new AlertDialog.Builder(SearchMain.this).create();

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



            }
        });



    }
}
