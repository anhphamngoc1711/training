package com.example.phonebook_advanced;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick{

    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContact);
        mAdapter.registerChildClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ":" + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(){
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName =(TextView) findViewById(R.id.tvName);

    }

    private void initData() {
        listContact.add(new ContactModel("Pham ngoc anh", "0898768888",R.drawable.ic_female));
        listContact.add(new ContactModel("Pham bao an", "0898762888",R.drawable.ic_male));
        listContact.add(new ContactModel("nguyen van a", "0898718888",R.drawable.ic_female));
        listContact.add(new ContactModel("Pham van b", "0898769888",R.drawable.ic_male));
        listContact.add(new ContactModel("nguyen van b","0123456789",R.drawable.ic_male));
        listContact.add(new ContactModel("nguyen van c","0123452788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van d","0123453788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van e","0123454788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van f","0123455788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van g","0123457788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van h","0123458788",R.drawable.ic_female));
        listContact.add(new ContactModel("nguyen van i","0123459788",R.drawable.ic_female));
    }
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.unRegisterChildClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}