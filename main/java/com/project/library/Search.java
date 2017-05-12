package com.project.library;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Search extends AppCompatActivity {

    private Button btnsearch;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new SessionManager(getApplicationContext());
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.library_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnsearch = (Button) findViewById(R.id.button5);

        btnsearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                String language = ((EditText) findViewById(R.id.editText)).getText().toString();
                String bookName = ((EditText) findViewById(R.id.editText2)).getText().toString();
                String author = ((EditText) findViewById(R.id.editText3)).getText().toString();

                Intent i = new Intent(getApplicationContext(),
                        SearchMain.class);
                i.putExtra("language", language);
                i.putExtra("bookName", bookName);
                i.putExtra("author", author);

                startActivity(i);

                //Cursor cursor = db.getBookDetails(bookName,language,author);
                //displayListView(cursor);


            }

        });



    }


   /* private void displayListView(Cursor cursor) {


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



    }*/

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
