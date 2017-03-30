package com.project.library;

/**
 * Created by harristhomas on 3/28/17. me modified test :-)
 */


        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

        import java.util.HashMap;

public class dbhelper extends SQLiteOpenHelper {

    private static final String TAG = dbhelper.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "library";

    // Login table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_BOOK = "book";
    private static final String TABLE_BORROW = "borrow";

    // Login Table Columns names
    private static final String KEY_ID = "user_id";
    private static final String KEY_NAME = "user_name";
    private static final String KEY_EMAIL = "user_email";
    private static final String KEY_ADD = "user_address";
    private static final String KEY_DOB = "user_dob";
    private static final String KEY_MOB = "user_mobile";
    private static final String KEY_PWD = "user_pwd";


    private static final String BOOK_ID = "book_id";
    private static final String BOOK_NAME = "book_name";
    private static final String BOOK_LANG = "book_language";
    private static final String BOOK_AUTH = "book_author";


    private static final String RETURN_DATE = "return_date";



    private static final String KEY_UID = "uid";
    private static final String KEY_CREATED_AT = "created_at";

    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " TEXT," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_ADD + " TEXT,"
                + KEY_DOB + " TEXT," + KEY_MOB + " TEXT,"
                + KEY_PWD + " TEXT" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

        String CREATE_BOOK_TABLE = "CREATE TABLE " + TABLE_BOOK + "("
                + BOOK_ID + " TEXT," + BOOK_NAME + " TEXT,"
                + BOOK_LANG + " TEXT,"
                + BOOK_AUTH + " TEXT" + ")";
        db.execSQL(CREATE_BOOK_TABLE);

        String CREATE_BORROW_TABLE = "CREATE TABLE " + TABLE_BORROW + "("
                + BOOK_ID + " TEXT," + KEY_ID + " TEXT,"
                + RETURN_DATE + " TEXT" + ")";
        db.execSQL(CREATE_BORROW_TABLE);

        Log.d(TAG, "Database tables created");




        ContentValues values = new ContentValues();
        values.put(BOOK_ID, "BK001"); // Name
        values.put(BOOK_NAME, "Programming Android"); // Email
        values.put(BOOK_LANG, "English"); // Email
        values.put(BOOK_AUTH, "Clarke");

        // Inserting Row
        long id = db.insert(TABLE_BOOK, null, values);

        values.put(BOOK_ID, "BK002"); // Name
        values.put(BOOK_NAME, "Programming Java"); // Email
        values.put(BOOK_LANG, "English"); // Email
        values.put(BOOK_AUTH, "Tim");

        // Inserting Row
         id = db.insert(TABLE_BOOK, null, values);

        values.put(BOOK_ID, "BK003"); // Name
        values.put(BOOK_NAME, "Sherlock Holmes"); // Email
        values.put(BOOK_LANG, "English"); // Email
        values.put(BOOK_AUTH, "Arthur Conan Doyle");

        // Inserting Row
         id = db.insert(TABLE_BOOK, null, values);
        //db.close(); // Closing database connection

        Log.d(TAG, "Books inserted: " + id);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);*/
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String uid,String name, String email, String address, String dob, String mobile, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Name
        values.put(KEY_EMAIL, email); // Email
        values.put(KEY_ID, uid); // Email
        values.put(KEY_ADD, address);
        values.put(KEY_DOB, dob);
        values.put(KEY_MOB, mobile);
        values.put(KEY_PWD,pwd);

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        /*String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("email", cursor.getString(2));
            user.put("uid", cursor.getString(3));
            user.put("created_at", cursor.getString(4));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());*/

        return user;
    }

    public HashMap<String, String> getBookDetails( String book , String language, String author) {
        HashMap<String, String> bookDetails = new HashMap<String, String>();
        String selectQuery  = "SELECT  * FROM " + TABLE_BOOK  + " where ";
        if(language!=null || !language.trim().isEmpty()){
            selectQuery = selectQuery + BOOK_LANG + " = " + language ;
        }

       /* if(book!=null || !book.trim().isEmpty()){
            selectQuery = selectQuery + BOOK_NAME + " = " + book ;
        }

        if(author!=null || !author.trim().isEmpty()){
            selectQuery = selectQuery + BOOK_AUTH + " = " + author ;
        }*/




        /*SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            bookDetails.put(BOOK_ID, cursor.getString(1));
            bookDetails.put(BOOK_NAME, cursor.getString(2));
            bookDetails.put(BOOK_LANG, cursor.getString(3));
            bookDetails.put(BOOK_AUTH, cursor.getString(4));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());*//*

        return user;*/


        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_BOOK, new String[] { BOOK_ID,BOOK_NAME,BOOK_LANG,BOOK_AUTH },null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
               /* String emailid=cursor.getString(0); // Here you can get data from table and stored in string if it has only one string.
                bookDetails.setText(emailid);*/


               String bookID = cursor.getString(0);
                String bookName = cursor.getString(1);
                String bookLang =cursor.getString(2);
                String bookAuth = cursor.getString(3);

               if(book!=null || !book.trim().isEmpty()){
                if(book.trim().equals(bookName.trim())){

                }else{
                    
                }
               }




            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if(db!=null)
        {
            db.close();
        }

        return bookDetails;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

}
