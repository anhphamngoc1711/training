package com.example.json_listview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.json_listview.R;
import com.example.json_listview.model.PostModel;

import java.util.List;

public class ListNewsAdapter extends BaseAdapter {
    private List<PostModel> listNews;
    private Activity activity;

    private ListNewsAdapter(){

    }

    public ListNewsAdapter(List<PostModel> listNews,Activity activity){
        this.listNews = listNews;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View covertView, ViewGroup parent) {
        if (covertView==null) {
            LayoutInflater layoutInflater  = activity.getLayoutInflater();
            covertView = layoutInflater.inflate(R.layout.activity_main,parent,false);
            ViewHodel hodel = new ViewHodel();
            hodel.tvTitle = covertView.findViewById(R.id.tvTitle);
        }

        return null;
    }
    public static class ViewHodel{
        TextView tvTitle;
        TextView tvDate;
        ImageView imageCover;
        TextView tvCotent;
    }
}
