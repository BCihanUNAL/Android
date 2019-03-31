package com.example.cihan.blm3520_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ShowActivity extends AppCompatActivity {
    private String tele;
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
        TextView tv6 = (TextView)findViewById(R.id.textView6);
        TextView tv7 = (TextView)findViewById(R.id.textView7);
        ImageView iv = (ImageView)findViewById(R.id.resimGos);
        Button b = (Button)findViewById(R.id.ders_gecis);
        ImageButton ib = findViewById(R.id.telefonAc);

        tele=intent.getStringExtra("telno");

        String gun=intent.getStringExtra("dGun"),ay=intent.getStringExtra("dAy"),yil=intent.getStringExtra("dYil");
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String date = df.format(Calendar.getInstance().getTime()),buyil=date.substring(0,4),buay=date.substring(4,6),bugun=date.substring(6,8);
        Integer yas=Integer.parseInt(buyil)-Integer.parseInt(yil);
        if(Integer.parseInt(buay)<Integer.parseInt(ay))
            yas--;
        else{
            if(Integer.parseInt(buay)==Integer.parseInt(ay)) {
                if (Integer.parseInt(bugun) < Integer.parseInt(gun))
                    yas--;
            }
        }

        tv1.setText("İsim: "+intent.getStringExtra("ad"));
        tv2.setText("Soyisim: "+intent.getStringExtra("soyad"));
        tv3.setText("Doğum Yeri: "+intent.getStringExtra("dyeri"));
        tv4.setText("T.C. Kimlik No: "+intent.getStringExtra("kno"));
        tv5.setText("Doğum Tarihi: "+gun+"/"+ay+"/"+yil);
        tv6.setText("Yaş: "+yas.toString());
        tv7.setText("Telefon Numarası: "+intent.getStringExtra("telno"));
        iv.setImageBitmap((Bitmap)intent.getParcelableExtra("foto"));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ShowActivity.this,DersActivity.class);
                startActivity(in);
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tel = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tele));
                startActivity(tel);
            }
        });
    }


}
