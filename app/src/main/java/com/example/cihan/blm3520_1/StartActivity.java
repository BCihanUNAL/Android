package com.example.cihan.blm3520_1;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    private static final String TAG = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button button = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText isim = (EditText)findViewById(R.id.kullanici);
                EditText sifre = (EditText)findViewById(R.id.sifre);

                if(!isim.getText().toString().equals("admin")||!sifre.getText().toString().equals("password")){
                    Toast.makeText(StartActivity.this, "Hatalı Kullanıcı Adı Yada Şifre", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
