package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button btLogin;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "pass";
    private SharedPreferences mPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = prefs.getString(KEY_NAME, null);//"No name defined" is the default value.
        String idName = prefs.getString(KEY_NAME, null);
        if(name != null && idName != null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
        getData();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edEmail.getText().toString();
                final String password = edPassword.getText().toString();
                if(username.length()==0)
                {
                    edEmail.requestFocus();
                    edEmail.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!username.matches("[a-zA-Z ]+"))
                {
                    edEmail.requestFocus();
                    edEmail.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                else if(password.length()==0)
                {
                    edPassword.requestFocus();
                    edPassword.setError("FIELD CANNOT BE EMPTY");
                }

                else if (!password.matches("^(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{6,}$")) {
                    edPassword.requestFocus();
                    edPassword.setError("Password includes at least 6 characters including 1 special character and 1 number");
                }
                else
                {
                    SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE).edit();
                    editor.putString(KEY_NAME, edEmail.getText().toString());
                    editor.putString(KEY_PASSWORD, edPassword.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getData() {
        edEmail = (EditText) findViewById(R.id.edEmail);
        edPassword = (EditText) findViewById(R.id.edPassword);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        btLogin = (Button) findViewById(R.id.btLogin);

    }
    private void saveLoginDetails()
    {
        //fill input boxes with stored login and pass
        EditText loginEbx = (EditText)findViewById(R.id.edEmail);
        EditText passEbx = (EditText)findViewById(R.id.edPassword);
        String login = loginEbx.getText().toString();
        String upass = passEbx.getText().toString();

        SharedPreferences.Editor e = mPrefs.edit();
        e.putBoolean("rememberMe", true);
        e.putString("login", login);
        e.putString("password", upass);
        e.commit();
    }
}