package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Detail extends AppCompatActivity {
    EditText txtjudulbuku, txtpengarang, txttahunterbit, txtpenerbit;
    Button btnkeluar;
    sql dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail Data Buku");

        btnkeluar = (Button) findViewById(R.id.btnkeluar);

        dbHelper = new sql(this);
        txtjudulbuku = (EditText) findViewById(R.id.txtjudulbuku);
        txtpengarang = (EditText) findViewById(R.id.txtpengarang);
        txttahunterbit = (EditText) findViewById(R.id.txttahunterbit);
        txtpenerbit = (EditText) findViewById(R.id.txtpenerbit);
        btnkeluar = (Button)findViewById(R.id.btnkeluar);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * from buku where judul_buku = '"+ getIntent().getStringExtra("judul_buku") +"'";
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            txtjudulbuku.setText(cursor.getString(1).toString());
            txtpengarang.setText(cursor.getString(2).toString());
            txttahunterbit.setText(cursor.getString(3).toString());
            txtpenerbit.setText(cursor.getString(4).toString());
        }
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Detail.this,DataBuku.class);
                startActivity(intent);
            }
        });

    }
}
