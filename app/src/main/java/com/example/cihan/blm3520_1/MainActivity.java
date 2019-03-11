package com.example.cihan.blm3520_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "MainActivity";
    private static String tarih;
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        tarih = adapterView.getItemAtPosition(i).toString();
        Log.d(TAG, "onItemSelected: "+tarih);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button);
        final EditText ad = (EditText) findViewById(R.id.ad);
        final EditText soyad = (EditText) findViewById(R.id.soyad);
        final EditText dyeri = (EditText) findViewById(R.id.dyeri);
        final Spinner dtarih = (Spinner) findViewById(R.id.dtarih);
        final EditText kno = (EditText) findViewById(R.id.kimlikno);
        final ImageButton b2 = (ImageButton) findViewById(R.id.resim);

        dtarih.setOnItemSelectedListener(this);

        String gAr[] = new String[31], aAr[] = new String[12], yAr[] = new String[59];
        Integer i, j;
        ArrayList<String> list = new ArrayList<>(), date = new ArrayList<>();

        for (i = 0; i < 31; i++) {
            j = i + 1;
            if (i < 12)
                aAr[i] = "";

            gAr[i] = "";
            if (i < 9) {
                aAr[i] += "0";
                gAr[i] += "0";
            }

            if (i < 12)
                aAr[i] += j.toString();

            gAr[i] += j.toString();
        }

        for (i = 1960; i < 2019; i++) {
            yAr[i - 1960] = i.toString();
        }

        for (i = 0; i < 12; i++) {
            for (j = 0; j < 31; j++) {
                if (i == 1 && j < 28) {
                    String s = gAr[j] + "/" + aAr[i];
                    list.add(s);
                    continue;
                }
                if ((i == 3 || i == 5 || i == 8 || i == 10) && j != 30) {
                    String s = gAr[j] + "/" + aAr[i];
                    list.add(s);
                    continue;
                }
                if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) {
                    String s = gAr[j] + "/" + aAr[i];
                    list.add(s);
                }
            }
        }

        for (i = 0; i < 59; i++) {
            for (j = 0; j < list.size(); j++) {
                date.add(list.get(j) + "/" + yAr[i]);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_adapter, date);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dtarih.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("ad", ad.getText().toString());
                intent.putExtra("soyad", soyad.getText().toString());
                intent.putExtra("dyeri", dyeri.getText().toString());
                intent.putExtra("kno", kno.getText().toString());
                intent.putExtra("dtarih",tarih);
                Bitmap bMap = ((BitmapDrawable)b2.getDrawable()).getBitmap();
                intent.putExtra("foto",bMap);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            final static int REQUEST_IMAGE_CAPTURE=1;
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final ImageButton resim = (ImageButton) findViewById(R.id.resim);
        final int REQUEST_IMAGE_CAPTURE=1;

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            resim.setImageBitmap(imageBitmap);
        }
    }
}
