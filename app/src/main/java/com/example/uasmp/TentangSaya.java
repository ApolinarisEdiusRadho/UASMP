package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TentangSaya extends AppCompatActivity {
    ImageView btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_saya);

        getSupportActionBar().hide();

        btnkembali = (ImageView) findViewById(R.id.btnkembali);

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(TentangSaya.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
