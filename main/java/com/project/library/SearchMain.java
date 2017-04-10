package com.project.library;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SearchMain extends AppCompatActivity {


    private dbhelper db;
    private SimpleCursorAdapter dataAdapter;
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



    }
}
