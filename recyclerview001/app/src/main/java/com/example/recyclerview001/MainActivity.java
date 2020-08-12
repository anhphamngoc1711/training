package com.example.recyclerview001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements ProductAdapter.IOnClickItem{
    List<Product> listProduct = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();


        ProductAdapter adapter = new ProductAdapter(this, listProduct, this);


        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);


        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }
    private void initData() {
        listProduct.add(new Product("Anh1","Love Shift1","1100.000",R.drawable.girl1));
        listProduct.add(new Product("Anh2","Love Shift2","1200.000",R.drawable.girl2));
        listProduct.add(new Product("Anh3","Love Shift3","1300.000",R.drawable.girl3));
        listProduct.add(new Product("Anh4","Love Shift4","1400.000",R.drawable.girl4));
        listProduct.add(new Product("Anh5","Love Shift5","1500.000",R.drawable.girl5));
        listProduct.add(new Product("Anh6","Love Shift6","1600.000",R.drawable.girl6));
    }

    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this, product.getTitle(),Toast.LENGTH_SHORT).show();
    }
}