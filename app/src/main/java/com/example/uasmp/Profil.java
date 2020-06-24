package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profil extends AppCompatActivity {
    TextView textuser;
    SharedPreference sp;
    Activity context = this;
    ImageView btnkembali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        getSupportActionBar().hide();

        sp = new SharedPreference();
        textuser=(TextView) findViewById(R.id.txtuserprofil);
        String email;
        email = sp.getValue(context, "email");

        textuser.setText(email);

        btnkembali = (ImageView) findViewById(R.id.btnkembali);

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Profil.this,MenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
