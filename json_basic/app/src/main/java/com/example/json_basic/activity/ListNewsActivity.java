package com.example.json_basic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.json_basic.R;
import com.example.json_basic.adapter.NewsAdapter;
import com.example.json_basic.interfaces.NewsOnClick;
import com.example.json_basic.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ListNewsActivity extends AppCompatActivity {

    ListView listView;
    NewsAdapter adapter;
    List<Item> listDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_list_news);

        //B1 Data source
        getData();

        //B2 Adapter
        adapter = new NewsAdapter(this, listDatas);

        //B3 Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        //B4 RecyclerViews
        RecyclerView rvViews = findViewById(R.id.rvNews);
        rvViews.setLayoutManager(layoutManager);
        rvViews.setAdapter(adapter);

        adapter.setiOnClick(new NewsOnClick() {
            @Override
            public void onClickItem(int position) {
                Item model = listDatas.get(position);
                Intent intent = new Intent(ListNewsActivity.this, DetailActivity.class);
                intent.putExtra("URL", model.getContent().getUrl());
                startActivity(intent);
                Log.d("TAG", "aa");
            }
        });
    }

    private void getData() {
    }
}
