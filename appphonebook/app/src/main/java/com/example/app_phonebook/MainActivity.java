package com.example.app_phonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initData() {
        ContactModel contact = new ContactModel("Nguyen Van A","012312345", R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van B", "012341234",R.drawable.ic_female);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van B", "012341234",R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van C", "012341235",R.drawable.ic_female);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van D", "012341236",R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van E", "012341237",R.drawable.ic_female);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van F", "012341238",R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van G", "012341239",R.drawable.ic_female);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van H", "012341230",R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van I", "012341212",R.drawable.ic_female);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van K", "012341213",R.drawable.ic_male);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van L", "012341214",R.drawable.ic_female);
        listContacts.add(contact);
    }
}