package com.example.uasmp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlpinjam extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="pinjam.db";
    private static final int DATABASE_VERSION=1;

    public sqlpinjam(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pinjam (id integer primary key autoincrement, " +
                "                                nim text null, " +
                "                                nama_mahasiswa text null," +
                "                                judul_buku text null, " +
                "                                tgl_pinjam text null, " +
                "                                tgl_kembali text null, " +
                "                                no_telp text null, " +
                "                                alamat text null);";

        Log.d("Data","OnCreate:" +sql);
        db.execSQL(sql);
        sql ="INSERT INTO pinjam(id,nim,nama_mahasiswa,judul_buku,tgl_pinjam,tgl_kembali,no_telp,alamat)" +
                "       VALUES(1,'18101045','Apolinaris Edius Radho','Mobile Programming','2020-02-10','2020-02-17','082145453545','Jl.Waturenggong');";
        db.execSQL(sql);

        sql ="INSERT INTO pinjam(id,nim,nama_mahasiswa,judul_buku,tgl_pinjam,tgl_kembali,no_telp,alamat)" +
                "       VALUES(2,'18101046','Eufronius Leonardo Beo','Jaringan Komputer Lanjut','2020-02-11','2020-02-21','081237896799','Jl.Tukad Pakerisan');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
