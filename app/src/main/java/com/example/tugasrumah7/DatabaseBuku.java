package com.example.tugasrumah7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseBuku extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_buku";

    private static final String tb_buku = "tb_buku";

    private static final String tb_bk_id = "id";
    private static final String tb_bk_judul = "judul";
    private static final String tb_bk_penerbit = "penerbit";
    private static final String tb_bk_tahun = "tahun";

    private static final String CREATE_TABLE_BUKU = "CREATE TABLE " + tb_buku + "("
            + tb_bk_id + " INTEGER PRIMARY KEY ,"
            + tb_bk_judul + " TEXT,"
            + tb_bk_penerbit + " TEXT,"
            + tb_bk_tahun + " TEXT " + ")";

    public DatabaseBuku (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BUKU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBuku (Buku mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_bk_id, mdNotif.get_id());
        values.put(tb_bk_judul, mdNotif.get_judul());
        values.put(tb_bk_penerbit, mdNotif.get_penerbit());
        values.put(tb_bk_tahun, mdNotif.get_tahun());
        db.insert(tb_buku, null, values);
        db.close();
    }

    public List<Buku> ReadBuku() {
        List<Buku> judulModelList = new ArrayList<Buku>();
        String selectQuery = "SELECT  * FROM " + tb_buku;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Buku mdKontak = new Buku();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_judul(cursor.getString(1));
                mdKontak.set_penerbit(cursor.getString(2));
                mdKontak.set_tahun(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateBuku (Buku mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_bk_judul, mdNotif.get_judul());
        values.put(tb_bk_penerbit, mdNotif.get_penerbit());
        values.put(tb_bk_tahun, mdNotif.get_tahun());

        return db.update(tb_buku, values, tb_bk_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }

    public void DeleteBuku (Buku mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_buku, tb_bk_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

