package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.danhba.adapter.ContactAdapter;
import com.example.danhba.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    private ArrayList<Contact> arrayContact;
    private EditText edtName;
    private ContactAdapter adapter;
    private EditText edtNumber;
    private RadioButton rbtMale;
    private RadioButton rbtFemale;
    private Button btnAddContact;
    private ListView lvContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWidget();
        arrayContact =new ArrayList<>();
        adapter =new ContactAdapter(this,R.layout.item_contact_lisview,arrayContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    public void setWidget(){
        edtName = (EditText)findViewById(R.id.edt_name);
        edtNumber = (EditText)findViewById(R.id.edt_number);
        rbtMale = (RadioButton)findViewById(R.id.rbtn_male);
        rbtFemale = (RadioButton)findViewById(R.id.rbtn_female);
        btnAddContact = (Button)findViewById(R.id.btn_add_contact);
        lvContact = (ListView)findViewById(R.id.lv_context);
    }
    public void addContact(View view){
        if (view.getId()==R.id.btn_add_contact){
            String name = edtName.getText().toString().trim();
            String number = edtNumber.getText().toString().trim();
            boolean isMale = true;
            if (rbtMale.isChecked()){
                isMale = true;
            }else {
                isMale = false;
            }
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(number)){
                Toast.makeText(this, "Please Input number or name", Toast.LENGTH_SHORT).show();
            }else {
                Contact contact = new Contact(isMale,name,number);
                arrayContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
    }
}