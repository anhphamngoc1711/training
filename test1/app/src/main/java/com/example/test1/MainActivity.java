package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edUser, edPassword;
    Button btLogin;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUser.getText().toString().trim();
                String password = edPassword.getText().toString().trim();

                if (username.equals("admin") && password.equals("admin")){
                    Toast.makeText(MainActivity.this, "ĐĂNG NHẬP THÀNH CÔNG",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Lỗi đăng nhập",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        edUser = (EditText) findViewById(R.id.edUser);
        edPassword = (EditText) findViewById(R.id.edPassword);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        btLogin = (Button) findViewById(R.id.btLogin);
    }
}