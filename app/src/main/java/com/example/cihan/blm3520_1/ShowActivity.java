package com.example.cihan.blm3520_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        TextView tv1 = (TextView)findViewById(R.id.textView);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        TextView tv3 = (TextView)findViewById(R.id.textView3);
        TextView tv4 = (TextView)findViewById(R.id.textView4);
        TextView tv5 = (TextView)findViewById(R.id.textView5);
        ImageView iv = (ImageView)findViewById(R.id.resimGos);

        tv1.setText("İsim: "+intent.getStringExtra("ad"));
        tv2.setText("Soyisim: "+intent.getStringExtra("soyad"));
        tv3.setText("Doğum Yeri: "+intent.getStringExtra("dyeri"));
        tv4.setText("T.C. Kimlik No: "+intent.getStringExtra("kno"));
        tv5.setText("Doğum Tarihi: "+intent.getStringExtra("dtarih"));
        iv.setImageBitmap((Bitmap)intent.getParcelableExtra("foto"));
    }
}
