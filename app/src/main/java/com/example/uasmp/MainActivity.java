package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText emailedittext;
    EditText passedittext;
    Button btnlogin;
    private SharedPreference sp;
    Activity context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        sp = new SharedPreference();
        emailedittext = (EditText) findViewById(R.id.txtusername);
        passedittext = (EditText) findViewById(R.id.txtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final String email = emailedittext.getText().toString();
                if(!isValidEmail(email)){
                    emailedittext.setError("Email Tidak Sesuai !");
                }else {
                    sp.save(context, "email", email);
                }

                final String pass = passedittext.getText().toString();
                if(!isValidPassword(pass)) {
                    passedittext.setError("Password Tidak Boleh Kosong / tidak Boleh Kurang Dari 6 Karakter !");
                }

                if(isValidEmail(email) && isValidPassword(pass)){
                    Toast.makeText(getApplicationContext(),  "Anda Berhasil Login",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean isValidEmail(String email){
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password){
        if (password != null && password.length() >= 6) {
            return true;
        }
        return false;
    }


}
