package com.project.library;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button startBtn = (Button) findViewById(R.id.sendmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    protected void sendEmail() {

        String[] TO = {"harris@baitalrayan.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto: harris@baitalrayan.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);

        String staffID = ((EditText) findViewById(R.id.editText)).getText().toString();
        String emailID = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String summary = ((EditText) findViewById(R.id.editText6)).getText().toString();

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query from "+staffID+" - "+emailID);
        emailIntent.putExtra(Intent.EXTRA_TEXT, summary);

        try {
            emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            alertDialog = new AlertDialog.Builder(Contact.this).create();

            alertDialog.setTitle("Email sent");

            alertDialog.setMessage("Email successfully sent to admin. ");

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int id) {

                    alertDialog.dismiss();

                } });

            alertDialog.show();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Contact.this, "Cannot send email. There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}





