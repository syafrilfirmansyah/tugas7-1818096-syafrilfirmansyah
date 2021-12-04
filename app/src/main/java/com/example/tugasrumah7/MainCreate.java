package com.example.tugasrumah7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private DatabaseBuku db;
    private EditText Ejudul, Epenerbit, Etahun;
    private String Sjudul, Spenerbit, Stahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new DatabaseBuku(this);

        Ejudul = (EditText) findViewById(R.id.create_judul);
        Epenerbit = (EditText) findViewById(R.id.create_penerbit);
        Etahun = (EditText) findViewById(R.id.create_tahun);

        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Sjudul = String.valueOf(Ejudul.getText());
                Spenerbit = String.valueOf(Epenerbit.getText());
                Stahun = String.valueOf(Etahun.getText());

                if (Sjudul.equals("")){
                    Ejudul.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi judul", Toast.LENGTH_SHORT).show();
                } else if (Spenerbit.equals("")){
                    Epenerbit.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi penerbit", Toast.LENGTH_SHORT).show();
                } else if (Stahun.equals("")){
                    Etahun.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tahun", Toast.LENGTH_SHORT).show();
                } else {
                    Ejudul.setText("");
                    Epenerbit.setText("");
                    Etahun.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateBuku(new Buku(null, Sjudul, Spenerbit, Stahun));

                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }

            }
        });
    }

}
