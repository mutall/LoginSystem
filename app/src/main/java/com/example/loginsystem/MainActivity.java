package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    Button add, delete;
    EditText data;
    ListView listView;
    ArrayAdapter adp;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Set<String> listItems;
    ArrayList arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        preferences = this.getSharedPreferences("mutall", Context.MODE_PRIVATE);
        editor = preferences.edit();

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        data = findViewById(R.id.data);
        listView = findViewById(R.id.listview);
        listItems = new HashSet<>();
        arrayList = new ArrayList();


        adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        listView.setAdapter(adp);


        View.OnClickListener addListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = data.getText().toString();
                if(!text.equals("")){
                    listItems.add(text);
                    editor.putStringSet("listItems", listItems);
                    editor.commit();

                }

            }
        };

        View.OnClickListener deleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adp.clear();
                data.setText("  ");
            }
        };


        add.setOnClickListener(addListener);
        delete.setOnClickListener(deleteListener);
    }
}
