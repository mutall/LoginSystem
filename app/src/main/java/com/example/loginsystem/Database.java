package com.example.loginsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = Database.class.getSimpleName();

    public Database(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: table created");
        db.execSQL(Query.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: table updated");
        db.execSQL(Query.DROP_TABLE);
        onCreate(db);
    }

    public void addContact(Contact contact){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("number", contact.getNumber());

        database.insertOrThrow(Query.TABLE_NAME,null, values);
//        database.rawQuery(Query.INSERT_CONTACT, new String[]{name, number});

    }

    public List<Contact> getAddresses(){
        List<Contact> contactsList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(Query.GET_ADDRESSES, null);

        if (cursor.moveToFirst()){
            do {
                String name = cursor.getString(1);
                Log.d(TAG, "getAddresses: name is" + name);
                String number = cursor.getString(2);
                Log.d(TAG, "getAddresses: phone number is" + number);

                Contact contact = new Contact(name, number);
                contactsList.add(contact);
            }while (cursor.moveToNext());
        }

        return contactsList;
    }


}
