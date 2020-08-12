package com.example.myapplication05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //b1 Data source
        final String[] datas = {"SAMSUNG", "LG", "SONY", "NOKIA", "APPLE", "HTC", "MOGOROLA"};


        //b2 Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);


        //b3 listview
        ListView listView = findViewById(R.id.lvContact);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String data = datas[position];
                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();

            }
        });
    }
}