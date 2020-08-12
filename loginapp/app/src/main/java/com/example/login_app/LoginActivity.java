package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edUser;
    private EditText edPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // gán
        edUser = (EditText)findViewById(R.id.edUser);
        edPassword = (EditText) findViewById(R.id.edPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(@org.jetbrains.annotations.NotNull View view) {
        // check login
        switch (view.getId())
        {
            case R.id.btnLogin:
                onLogin();
                break;
            default:
                break;
        }
    }
    private void onLogin() {
        if (edUser.getText().toString().isEmpty() || edPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "You have not entered a username or password", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USER_NAME", edUser.getText().toString());
            startActivity(intent);

        }
    }
}