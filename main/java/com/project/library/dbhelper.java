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

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.Date;
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


    public static final String BOOK_ID = "book_id";
    public static final String BOOK_NAME = "book_name";
    public static final String BOOK_LANG = "book_language";
    public static final String BOOK_AUTH = "book_author";


    public static final String RETURN_DATE = "return_date";

   // public static final String _ID = "_id"; // This column needed for adapter



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
                + BOOK_ID + " TEXT," + KEY_ID + " TEXT," + BOOK_NAME + " TEXT,"
                + BOOK_LANG + " TEXT,"
                + BOOK_AUTH + " TEXT,"
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
    public boolean addUser(String uid,String name, String email, String address, String dob, String mobile, String pwd) {
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
        return true;
    }

    /**
     * Getting user data from database
     * */
    public String getUserDetails(String user) {
        //HashMap<String, String> user = new HashMap<String, String>();
        String pwd = "";
        /*String selectQuery = "SELECT "+ KEY_PWD +" FROM " + TABLE_USER + " where "+KEY_ID+ " = '"+user+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            pwd = cursor.getString(1);
        }
        cursor.close();
        db.close();
        // return user
        //Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return pwd;*/


        SQLiteDatabase db = this.getWritableDatabase();

        String table = TABLE_USER;
        String[] columns = { "rowid _id", KEY_PWD};
        String selection = KEY_ID + "=?";;
        String[] selectionArgs={user} ;
        String groupBy = null;
        String having = null;
        String orderBy =null;
        String limit = null;



        Cursor cursor = db.query(table, columns,selection, selectionArgs, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            if (cursor.getCount() > 0) {
                pwd = cursor.getString(1);
            }
            cursor.close();
            db.close();
        }
        return pwd;
    }

    public Cursor getBookDetails( String book , String language, String author) {

        SQLiteDatabase db = this.getWritableDatabase();

        String table = TABLE_BOOK;
        String[] columns = { "rowid _id", BOOK_ID,BOOK_NAME,BOOK_LANG,BOOK_AUTH};
        String selection = null;
        String[] selectionArgs=null ;
        String groupBy = null;
        String having = null;
        String orderBy =null;
        String limit = null;


        ArrayList<String> selectionList = new ArrayList<String> ();

        if(book!=null && !book.trim().equals("")){
            selection =  BOOK_NAME + " like ? ";
            selectionList.add("%"+book+"%");
        }

        if(language!=null && !language.trim().equals("")){

            if(selection ==null ){
                selection = BOOK_LANG + " like ? ";

            }else{
                selection = selection + " AND "+BOOK_LANG + " like ? ";
            }

            selectionList.add("%"+language+"%");

        }

        if(author!=null && !author.trim().equals("")){

            if(selection == null ){
                selection =  BOOK_AUTH + " like ? ";
            }else{
                selection = selection + " AND "+BOOK_AUTH + " like ? ";
            }

            selectionList.add("%"+author+"%");

        }

        if(selectionList !=null && !selectionList.isEmpty()){
            selectionArgs = selectionList.toArray(new String[0]);
        }




        Cursor cursor = db.query(table, columns,selection, selectionArgs, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

    }


    public Cursor getBookBorrowDetails( String userName) {

        SQLiteDatabase db = this.getWritableDatabase();

        String table = TABLE_BORROW;
        String[] columns = { "rowid _id", BOOK_ID,BOOK_NAME,BOOK_LANG,BOOK_AUTH,RETURN_DATE};
        String selection = KEY_ID + "=?";
        String[] selectionArgs={userName} ;
        String groupBy = null;
        String having = null;
        String orderBy =null;
        String limit = null;



        Cursor cursor = db.query(table, columns,selection, selectionArgs, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;

    }

    public boolean addBorrowBook(String uid,String bookID, String bookName, String bookLang, String bookAuth) {
        SQLiteDatabase db = this.getWritableDatabase();

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        ContentValues values = new ContentValues();
        values.put(KEY_ID, uid);
        values.put(BOOK_ID, bookID);
        values.put(BOOK_NAME, bookName);
        values.put(BOOK_LANG, bookLang);
        values.put(BOOK_AUTH, bookAuth);
        values.put(RETURN_DATE, formattedDate);


        // Inserting Row
        long id = db.insert(TABLE_BORROW, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
        return true;
    }

    public boolean extendBorrowDate(String bookID, String date) throws ParseException {
        SQLiteDatabase db = this.getWritableDatabase();


        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar cal = df.getCalendar();
        cal.setTime(df.parse(date));
        cal.add(Calendar.WEEK_OF_YEAR, 1);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = sdf.format(cal.getTime());


        ContentValues values = new ContentValues();
        values.put(RETURN_DATE, formattedDate);


        // Updating Row
        long id = db.update(TABLE_BORROW, values, BOOK_ID + "='" + bookID+"'", null);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
        return true;
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
