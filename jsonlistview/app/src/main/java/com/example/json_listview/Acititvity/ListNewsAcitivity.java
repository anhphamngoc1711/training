package com.example.json_listview.Acititvity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.json_listview.R;
import com.example.json_listview.adapter.ListNewsAdapter;
import com.example.json_listview.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class ListNewsAcitivity  extends AppCompatActivity {

    ListView listView;
    ListNewsAdapter adapter;
    List<PostModel> listNews = new ArrayList<>();

    protected void onCreate(Bundle saveInstanceStace){
        super.onCreate(saveInstanceStace);
        setContentView(R.layout.activity_list_news);
        lvNews = findViewById(R.id.lvNews);

        //B1 : Datasurce
        parserListNews();

        adapter
    }
}
