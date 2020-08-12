package com.example.traning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private EditText edUser, edPassword;
    private CheckBox remember;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUser = (EditText) findViewById(R.id.edUser);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        remember = (CheckBox) findViewById(R.id.remember);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btLogin:
                onLogin();
                break;
            default:
                break;
        }
    }

    private void onLogin() {
        if (edUser.getText().toString().isEmpty()|| edPassword.getText().toString().isEmpty()  ) {
            Toast.makeText(this, "Bạn chưa nhập username hoặc password", Toast.LENGTH_SHORT).show();
        }
        if (edPassword.)
    remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton.isChecked()){
                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "true");
                editor.apply();
                Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

}