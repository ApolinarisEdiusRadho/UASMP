package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailPinjam extends AppCompatActivity {
    EditText txtnim, txtnamamahasiswa, txtjudulbuku, txtpinjam, txtkembali, txttelepon, txtalamat;
    Button btnkeluar;
    sqlpinjam dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pinjam);

        getSupportActionBar().setTitle("Detail Data Peminjaman");

        dbHelper = new sqlpinjam(this);
        txtnim = (EditText) findViewById(R.id.txtnim);
        txtnamamahasiswa = (EditText) findViewById(R.id.txtnamamahasiswa);
        txtjudulbuku = (EditText) findViewById(R.id.txtjudulbuku);
        txtpinjam = (EditText) findViewById(R.id.txtpinjam);
        txtkembali = (EditText) findViewById(R.id.txtkembali);
        txttelepon = (EditText) findViewById(R.id.txttelepon);
        txtalamat = (EditText) findViewById(R.id.txtalamat);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * from pinjam where nim = '" + getIntent().getStringExtra("nim") + "'";
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            txtnim.setText(cursor.getString(1).toString());
            txtnamamahasiswa.setText(cursor.getString(2).toString());
            txtjudulbuku.setText(cursor.getString(3).toString());
            txtpinjam.setText(cursor.getString(4).toString());
            txtkembali.setText(cursor.getString(5).toString());
            txttelepon.setText(cursor.getString(6).toString());
            txtalamat.setText(cursor.getString(7).toString());

        }
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(DetailPinjam.this,DataPeminjaman.class);
                startActivity(intent);
            }
        });
    }
}
