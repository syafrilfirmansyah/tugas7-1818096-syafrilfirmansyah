package com.example.tugasrumah7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private DatabaseBuku db;
    private String Sid, Sjudul, Spenerbit, Stahun;
    private EditText Ejudul, Epenerbit, Etahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new DatabaseBuku(this);

        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sjudul = i.getStringExtra("Ijudul");
        Spenerbit = i.getStringExtra("Ipenerbit");
        Stahun = i.getStringExtra("Itahun");

        Ejudul = (EditText) findViewById(R.id.update_judul);
        Epenerbit = (EditText) findViewById(R.id.update_penerbit);
        Etahun = (EditText) findViewById(R.id.update_tahun);

        Ejudul.setText(Sjudul);
        Epenerbit.setText(Spenerbit);
        Etahun.setText(Stahun);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sjudul = String.valueOf(Ejudul.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                Stahun = String.valueOf(Etahun.getText());
                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi judul", Toast.LENGTH_SHORT).show();
                } else if (Spenerbit.equals("")){
                    Epenerbit.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi penerbit", Toast.LENGTH_SHORT).show();
                } else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tahun", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBuku(new Buku(Sid, Sjudul, Spenerbit, Stahun));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBuku(new Buku(Sid, Sjudul, Spenerbit, Stahun));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}