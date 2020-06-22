package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahActivity extends AppCompatActivity {
    sql dbHelper;
    Button btntambah;
    EditText txtjudulbuku, txtpengarang, txttahunterbit, txtpenerbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        getSupportActionBar().setTitle("Tambah Data Buku");

        dbHelper = new sql(this);
        txtjudulbuku = (EditText)findViewById(R.id.txtjudulbuku);
        txtpengarang = (EditText)findViewById(R.id.txtpengarang);
        txttahunterbit = (EditText)findViewById(R.id.txttahunterbit);
        txtpenerbit = (EditText)findViewById(R.id.txtpenerbit);
        btntambah = (Button)findViewById(R.id.btntambah);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "INSERT INTO buku (judul_buku, nama_pengarang, tahun_terbit, penerbit)" +
                        "     VALUES ('"+ txtjudulbuku.getText().toString() +"'," +
                        "             '"+ txtpengarang.getText().toString() +"'," +
                        "             '"+ txttahunterbit.getText().toString() +"'," +
                        "             '"+ txtpenerbit.getText().toString() +"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(),"Berhasil Menambahkan Data", Toast.LENGTH_LONG).show();
                DataBuku.bd.RefreshList();
                finish();
            }
        });
    }
}
