package com.project.library;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Search extends AppCompatActivity {

    private Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.library_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

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
}
