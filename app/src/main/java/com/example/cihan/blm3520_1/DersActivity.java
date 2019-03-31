package com.example.cihan.blm3520_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders);
        final ArrayList<Dersler> list = new ArrayList<>();

        list.add(new Dersler("BBG","AA"));
        list.add(new Dersler("Mat1","AA"));
        list.add(new Dersler("Fizik","AA"));
        list.add(new Dersler("Türkçe","AA"));
        list.add(new Dersler("Mat2","AA"));

        MyAdapter adapter = new MyAdapter(list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DersActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
