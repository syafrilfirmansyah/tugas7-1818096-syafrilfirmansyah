package com.example.tugasrumah7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseBuku db;
    private List<Buku> ListBuku = new ArrayList<Buku>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new DatabaseBuku(this);

        adapter_off = new CustomListAdapter(this, ListBuku );
        mListView = (ListView) findViewById(R.id.list_buku);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListBuku.clear();

        List<Buku> contacts = db.ReadBuku();
        for (Buku cn : contacts) {
            Buku judulModel = new Buku();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_penerbit(cn.get_penerbit());
            judulModel.set_tahun(cn.get_tahun());
            ListBuku.add(judulModel);

            if ((ListBuku.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Buku obj_itemDetails = (Buku)o;

        String Sid = obj_itemDetails.get_id();
        String Sjudul = obj_itemDetails.get_judul();
        String Spenerbit = obj_itemDetails.get_penerbit();
        String Stahun = obj_itemDetails.get_tahun();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijudul", Sjudul);
        goUpdel.putExtra("Ipenerbit", Spenerbit);
        goUpdel.putExtra("Itahun", Stahun);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListBuku.clear();
        mListView.setAdapter(adapter_off);

        List<Buku> contacts = db.ReadBuku();
        for (Buku cn : contacts) {
            Buku judulModel = new Buku();
            judulModel.set_id(cn.get_id());
            judulModel.set_judul(cn.get_judul());
            judulModel.set_penerbit(cn.get_penerbit());
            judulModel.set_tahun(cn.get_tahun());
            ListBuku.add(judulModel);

            if ((ListBuku.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}