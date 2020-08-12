package com.example.myapplication_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;
    private static final int REQUEST_CODE = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","onCreate");
        Button btClick = (Button) findViewById(R.id.btnClick);
        Button btCancel = (Button) findViewById(R.id.btnCannel);
        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Chao ban"); // doi ten
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TEST","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }
}