package com.example.latihanlagi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HalamanUtama extends AppCompatActivity {
    TextView txtNama, txtUsia, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
        txtNama = findViewById(R.id.txtNama);
        txtUsia = findViewById(R.id.txtUsia);
        txtStatus = findViewById(R.id.txtStatus);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            txtNama.setText("Nama : " + extras.getString("Nama", ""));
            txtUsia.setText("Usia : " + extras.getInt("Usia", 0));
            String status =  extras.getBoolean("Status", false) ? "Menikah" : "Lajang";

            txtStatus.setText("Status : " + status);
        }
    }
}
