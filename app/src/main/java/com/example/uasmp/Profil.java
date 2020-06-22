package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Profil extends AppCompatActivity {
    TextView textuser;
    SharedPreference sp;
    Activity context = this;

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
    }
}
