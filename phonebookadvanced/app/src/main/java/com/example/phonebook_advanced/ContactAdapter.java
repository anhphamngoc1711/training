package com.example.phonebook_advanced;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private Context mContext;
    private List<ContactModel> listContact;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context mContext,List<ContactModel> listContact){
        this.mContext = mContext;
        this.listContact =listContact;
    }
    public void registerChildClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick = iOnChildItemClick;
    }
    public void unRegisterChildClick(){
        this.iOnChildItemClick = null;
    }


    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View covertView, ViewGroup viewGroup) {
        View rowView  = covertView;
        if (rowView==null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact,null);

            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) rowView.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) rowView.findViewById(R.id.imAvatar);
            holder.btCall = (Button) rowView.findViewById(R.id.btCall);
            rowView.setTag(holder);

        }
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContact.get(i).getName());
        holder.tvPhone.setText(listContact.get(i).getPhone());
        holder.ivAvatar.setImageResource(listContact.get(i).getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(i);
            }
        });

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnChildItemClick.onItemChildClick(i);
            }
        });

        return rowView;
    }
    private void onCall(int position){
        ContactModel contact = listContact.get(position);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        mContext.startActivity(intent);
    }
    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        Button btCall;
        Button btEdit;
    }
}
