package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private static final String TAG = MainActivity.class.getSimpleName();
EditText text;
EditText number;
Button save,fetch;
Database database;
String data;
String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        database = new Database(this);
        text = findViewById(R.id.name);
        number = findViewById(R.id.number);
        save = findViewById(R.id.btn);
        fetch = findViewById(R.id.fetch);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = text.getText().toString();
                num = number.getText().toString();
                Log.d(TAG, "onClick: data is"+data);
                Contact contact = new Contact(data,num);

                Log.d(TAG, "onClick: contct added"+contact.getName());
                database.addContact(contact);


            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> list = database.getAddresses();
                for(Contact c: list){
                    Log.d(TAG, "onClick: name ="+ c.getName() +" Number ="+c.getNumber());
                }

            }
        });

    }

}
