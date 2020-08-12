package com.example.listview_05_adv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private Context mContext;
    List<ContactModel> lisContact;
    private IOnChildItemClick iOnChildItemClick;
    private View convertView;

    public ContactAdapter(Context mContext, List<ContactModel> lisContact, IOnChildItemClick iOnChildItemClick) {
        this.mContext = mContext;
        this.lisContact = lisContact;
        this.iOnChildItemClick = iOnChildItemClick;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public List<ContactModel> getLisContact() {
        return lisContact;
    }

    public void setLisContact(List<ContactModel> lisContact) {
        this.lisContact = lisContact;
    }

    public IOnChildItemClick getiOnChildItemClick() {
        return iOnChildItemClick;
    }

    public void setiOnChildItemClick(IOnChildItemClick iOnChildItemClick) {
        this.iOnChildItemClick = iOnChildItemClick;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = convertView;
        // reuse view
        if (rowView==null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact,null);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) rowView.findViewById(R.id.tvPhone);
        }
        return null;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvPhone;
        ImageView ivUser;

    }
}
