package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahPinjam extends AppCompatActivity {
    sqlpinjam dbHelper;
    Button btntambahpinjam;
    EditText txtnim, txtnamamahasiswa, txtjudulbuku, txtpinjam,txtkembali,txttelepon,txtalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pinjam);

        getSupportActionBar().setTitle("Tambah Data Peminjam");

        dbHelper = new sqlpinjam(this);
        txtnim = (EditText)findViewById(R.id.txtnim);
        txtnamamahasiswa = (EditText)findViewById(R.id.txtnamamahasiswa);
        txtjudulbuku = (EditText)findViewById(R.id.txtjudulbuku);
        txtpinjam = (EditText)findViewById(R.id.txtpinjam);
        txtkembali = (EditText)findViewById(R.id.txtkembali);
        txttelepon = (EditText)findViewById(R.id.txttelepon);
        txtalamat = (EditText)findViewById(R.id.txtalamat);
        btntambahpinjam = (Button)findViewById(R.id.btntambahpinjam);

        btntambahpinjam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "INSERT INTO pinjam (nim, nama_mahasiswa, judul_buku, tgl_pinjam, tgl_kembali, no_telp, alamat)" +
                        "     VALUES ('"+ txtnim.getText().toString() +"'," +
                        "             '"+ txtnamamahasiswa.getText().toString() +"'," +
                        "             '"+ txtjudulbuku.getText().toString() +"'," +
                        "             '"+ txtpinjam.getText().toString() +"'," +
                        "             '"+ txtkembali.getText().toString() +"'," +
                        "             '"+ txttelepon.getText().toString() +"'," +
                        "             '"+ txtalamat.getText().toString() +"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(),"Berhasil Menambahkan Data", Toast.LENGTH_LONG).show();
                DataPeminjaman.bd.RefreshList();
                finish();
            }
        });
    }
}
