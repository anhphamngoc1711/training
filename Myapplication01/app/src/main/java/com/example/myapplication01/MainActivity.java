package com.example.myapplication01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonLogin;
    TextView tvTitle;
    ImageView imCover;
    EditText edUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        // phep gan
        buttonLogin = findViewById(R.id.btLogin);
        tvTitle = findViewById(R.id.tvTitle);
        imCover = findViewById(R.id.imgCover);
        edUser = findViewById(R.id.edUser);

        // bắt sự kiện khi người dùng click vào button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTitle.setText("Anh");
                imCover.setImageResource(R.drawable.funny02); // đổi ảnh
                String username = edUser.getText().toString();
                tvTitle.setText(username);
            }
        });
    }
}