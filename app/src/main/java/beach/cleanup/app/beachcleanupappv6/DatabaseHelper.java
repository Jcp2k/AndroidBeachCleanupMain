package beach.cleanup.app.beachcleanupappv6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name
    public static final String datbaseName = "Signup.db";


    // Constructor for DatabaseHelper.
    // Sets the context in which to operate the database in.

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

// Create Database on first Signup input. Mydatabase is the parameter in which it is created into.
// Saves in table giving both and EMAIL and password text from the Edittext boxes on the Signup Page.


    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create table allusers(email TEXT primary key, password TEXT)");

    }
// Called when Database has already been created on Computer, when Database already exists it instead updates to fit new data.
    // Then new database is created and replaces old previous version.
    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists allusers");
        onCreate(MyDatabase);

    }
    // Inserts a new user's data into the database. email is The user's email. password The user's password.
    // @return True if the data was inserted successfully, false otherwise.

    public Boolean InsertData(String email, String password ) {
        SQLiteDatabase Mydatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = Mydatabase.insert("allusers", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Check if the email and password are found in the database.
    // If not read out Toast statements set around whether or not the password/email.

    public  Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?",new String[]{email});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?",new String[]{email, password});

        if (cursor.getCount() >0){
            return true;
        } else {
            return false;
        }
    }
}
