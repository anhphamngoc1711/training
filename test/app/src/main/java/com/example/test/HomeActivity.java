package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity  {
    TextView tvUsername;
    Button btEdit;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsername =findViewById(R.id.tvEmail);
        btEdit = findViewById(R.id.btEdit);


      btEdit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              SharedPreferences settings = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
              settings.edit().clear().apply();
              Intent intent = new Intent(HomeActivity.this,MainActivity.class);
    startActivity(intent);
    finish();
}
      });
              }




              }