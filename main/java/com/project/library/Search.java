package com.project.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Search extends AppCompatActivity {

    private Button btnsearch;
    private dbhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        btnsearch = (Button) findViewById(R.id.button5);
        db  = new dbhelper(getApplicationContext());
        btnsearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                String language = ((EditText) findViewById(R.id.editText)).getText().toString();
                String bookName = ((EditText) findViewById(R.id.editText2)).getText().toString();
                String author = ((EditText) findViewById(R.id.editText3)).getText().toString();

                db.getBookDetails(bookName,language,author);
            }

        });

    }
}
