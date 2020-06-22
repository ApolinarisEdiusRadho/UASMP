package com.example.uasmp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPinjam extends AppCompatActivity {
    EditText txtnim, txtnamamahasiswa, txtjudulbuku, txtpinjam, txtkembali, txttelepon, txtalamat;
    Button btnsimpanedit;
    sqlpinjam dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pinjam);

        getSupportActionBar().setTitle("Mengubah Data Peminjaman");

        dbHelper = new sqlpinjam(this);
        txtnim = (EditText) findViewById(R.id.txtnim);
        txtnamamahasiswa = (EditText) findViewById(R.id.txtnamamahasiswa);
        txtjudulbuku = (EditText) findViewById(R.id.txtjudulbuku);
        txtpinjam = (EditText) findViewById(R.id.txtpinjam);
        txtkembali = (EditText) findViewById(R.id.txtkembali);
        txttelepon = (EditText) findViewById(R.id.txttelepon);
        txtalamat = (EditText) findViewById(R.id.txtalamat);
        btnsimpanedit = (Button) findViewById(R.id.btnsimpanedit);

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

        btnsimpanedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "UPDATE pinjam SET nim = '" + txtnim.getText().toString() + "'," +
                        "     nama_mahasiswa      = '" + txtnamamahasiswa.getText().toString() + "'," +
                        "          judul_buku     = '" + txtjudulbuku.getText().toString() + "'," +
                        "          tgl_pinjam     = '" + txtpinjam.getText().toString() + "'," +
                        "          tgl_kembali    = '" + txtkembali.getText().toString() + "'," +
                        "             no_telp     = '" + txttelepon.getText().toString() + "'," +
                        "                alamat   = '" + txtalamat.getText().toString() + "'" +
                        "WHERE nim = '" + getIntent().getStringExtra("nim") + "'";

                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Berhasil Mengubah Data", Toast.LENGTH_LONG).show();
                DataBuku.bd.RefreshList();
                finish();
            }
        });
    }
}

