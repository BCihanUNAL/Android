package com.example.cihan.blm3520_1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
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
    private static String tarihG="??",tarihA="??",tarihY="????";
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(getResources().getResourceEntryName(adapterView.getId()).equals("dGun"))
            tarihG = adapterView.getItemAtPosition(i).toString();
        if(getResources().getResourceEntryName(adapterView.getId()).equals("dAy"))
            tarihA = adapterView.getItemAtPosition(i).toString();
        if(getResources().getResourceEntryName(adapterView.getId()).equals("dYil"))
            tarihY = adapterView.getItemAtPosition(i).toString();
        Log.d(TAG, "onItemSelected: "+tarihG+" "+tarihA+" "+tarihY);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        final ImageButton resim = (ImageButton) findViewById(R.id.resim);
        outState.putParcelable("bitmap",((BitmapDrawable)resim.getDrawable()).getBitmap());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        final ImageButton resim = (ImageButton) findViewById(R.id.resim);
        Bitmap resim_bitmap = (Bitmap) savedInstanceState.get("bitmap");
        resim.setImageBitmap(resim_bitmap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button);
        final EditText ad = (EditText) findViewById(R.id.ad);
        final EditText soyad = (EditText) findViewById(R.id.soyad);
        final EditText dyeri = (EditText) findViewById(R.id.dyeri);
        final EditText telefon = (EditText)findViewById(R.id.telNo);
        final Spinner dGun = (Spinner) findViewById(R.id.dGun);
        final Spinner dAy = (Spinner) findViewById(R.id.dAy);
        final Spinner dYil = (Spinner) findViewById(R.id.dYil);
        final EditText kno = (EditText) findViewById(R.id.kimlikno);
        final ImageButton b2 = (ImageButton) findViewById(R.id.resim);

        dGun.setOnItemSelectedListener(this);
        dAy.setOnItemSelectedListener(this);
        dYil.setOnItemSelectedListener(this);

        String gAr[] = new String[31], aAr[] = new String[12], yAr[] = new String[59];
        Integer i, j;
        ArrayList<String> list = new ArrayList<>(), dateY = new ArrayList<>(),dateM=new ArrayList<>(),dateD=new ArrayList<>();

        for(i=1;i<=31;i++){
            dateD.add(i.toString());
        }
        for(i=1;i<=12;i++){
            dateM.add(i.toString());
        }
        for(i=1900;i<=2019;i++){
            dateY.add(i.toString());
        }

        /*for (i = 0; i < 31; i++) {
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
        }*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.layout_adapter, dateD);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dGun.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.layout_adapter, dateM);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dAy.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.layout_adapter, dateY);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dYil.setAdapter(adapter2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("ad", ad.getText().toString());
                intent.putExtra("soyad", soyad.getText().toString());
                intent.putExtra("dyeri", dyeri.getText().toString());
                intent.putExtra("telno", telefon.getText().toString());
                intent.putExtra("kno", kno.getText().toString());
                intent.putExtra("dGun",tarihG);
                intent.putExtra("dAy",tarihA);
                intent.putExtra("dYil",tarihY);
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
