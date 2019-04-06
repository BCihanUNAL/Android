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

        list.add(new Dersler("Ders İsmi", "Not", "", 0.0f));


        list.add(new Dersler("BBG", "AA", "80", 44.0f));
        list.add(new Dersler("Mat1","AA", "50", 51.0f));
        list.add(new Dersler("Fizik","AA", "60", 46.0f));
        list.add(new Dersler("Türkçe","AA","40", 65.0f));
        list.add(new Dersler("Mat2","AA", "50", 48.0f));

        MyAdapter adapter = new MyAdapter(list,DersActivity.this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DersActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
