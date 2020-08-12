package com.example.danhba.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.danhba.R;
import com.example.danhba.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> arrayContact;

    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource= resource;
        this.arrayContact= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_lisview,parent,false);
            viewHolder.imgAvatar = (ImageView)convertView.findViewById(R.id.img_avatar);
            viewHolder.tvnName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tv_number);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contact = arrayContact.get(position);

        viewHolder.tvnName.setText(contact.getmName());
        viewHolder.tvNumber.setText(contact.getmNumber());

        if (contact.isMale()){
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_male);
        }else {
            viewHolder.imgAvatar.setBackgroundResource(R.drawable.ic_female);
        }
        return convertView;
    }
    public class ViewHolder{
        ImageView imgAvatar;
        TextView tvnName;
        TextView tvNumber;

    }
}
