package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MenuActivity extends AppCompatActivity {
    private CardView btnprofil, btnkeluar, btnbuku, btnpinjam, btnsaya;
//    ImageView btnprofil, btnkeluar, btnbuku, btnpinjam;
    SharedPreference sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();

        btnprofil = (CardView) findViewById(R.id.btnprofil);
        btnkeluar = (CardView) findViewById(R.id.btnkeluar);
        btnbuku = (CardView) findViewById(R.id.btnbuku);
        btnpinjam = (CardView) findViewById(R.id.btnpinjam);
        btnsaya = (CardView)  findViewById(R.id.btnsaya);

        sp = new SharedPreference();

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MenuActivity.this,Profil.class);
                startActivity(intent);
            }
        });

        btnbuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MenuActivity.this,DataBuku.class);
                startActivity(intent);
            }
        });

        btnpinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MenuActivity.this,DataPeminjaman.class);
                startActivity(intent);
            }
        });

        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sp.clearSharedPreference(context);
                finish();
            }
        });

        btnsaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MenuActivity.this,TentangSaya.class);
                startActivity(intent);
            }
        });
    }

}
