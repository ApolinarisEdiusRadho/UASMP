package com.example.uasmp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

public class sql extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="buku.db";
    private static final int DATABASE_VERSION=1;

    public sql(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table buku (id integer primary key autoincrement, " +
                "                                judul_buku text null, " +
                "                                nama_pengarang text null," +
                "                                tahun_terbit text null, " +
                "                                penerbit text null);";

        Log.d("Data","OnCreate:" +sql);
        db.execSQL(sql);
        sql ="INSERT INTO buku(id,judul_buku,nama_pengarang,tahun_terbit,penerbit)" +
                "       VALUES(1,'Mobile Programing','Mukidi','2000','Media Com');";
        db.execSQL(sql);

        sql ="INSERT INTO buku(id,judul_buku,nama_pengarang,tahun_terbit,penerbit)" +
                "       VALUES(2,'Algoritma Pemrograman','Mukhlis','2002','Comdia');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
