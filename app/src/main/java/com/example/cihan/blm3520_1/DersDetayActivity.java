package com.example.cihan.blm3520_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DersDetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_detay);
        TextView tv1 = (TextView)findViewById(R.id.dersadi);
        TextView tv2 = (TextView)findViewById(R.id.kisi);
        TextView tv3 = (TextView)findViewById(R.id.ort);

        Intent intent = getIntent();

        Float val=intent.getFloatExtra("ortalama",-1.0f);
        String tv3Text;

        if(val == -1.0f){
            tv3Text="Hata";
        }
        else{
            tv3Text=val.toString();
        }

        tv1.setText(intent.getStringExtra("ders_isim"));
        tv2.setText(intent.getStringExtra("kisi"));
        tv3.setText(tv3Text);
    }
}
