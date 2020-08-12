package com.example.app_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView tvUser;
    private Button btEdit;
    private static final  int REQUEST_CODE = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_profile);

        tvUser = findViewById(R.id.tvUsername);
        btEdit = findViewById(R.id.btEdit);
        btEdit.setOnClickListener(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        tvUser.setText(username);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btEdit:
                onEdit();
                break;
            default:
                break;
        }
    }
    public void onEdit(){
        Intent intent = new Intent(this, EditUserActivity.class);
        intent.putExtra("USERNAME",tvUser.getText().toString());
        startActivityForResult(intent,REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, requestCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String result = data.getStringExtra("RESULT");
                tvUser.setText(result);
            }
        }
    }
}