package com.example.latihanlagi; //komen

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPindah; //dklarasi button
    Button buttonBrowser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Kondisi", "onCreate");

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 3000);

        buttonPindah = findViewById(R.id.buttonPindah); //inisialisasi button
        buttonBrowser = findViewById(R.id.buttonBrowser);
        //cara pertama
        //buttonPindah.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {

            //}
        //});


        //cara kedua
        buttonPindah.setOnClickListener(this);
        buttonBrowser.setOnClickListener(this);

        //cara ketiga
        //buttonPindah.setOnClickListener(fungsiPindah);
    }

   // View.OnClickListener fungsiPindah = new View.OnClickListener() {
     //   @Override
       // public void onClick(View v) {
         //   Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
           // startActivity(intent);
        //}
    //};

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Kondisi", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Kondisi", "onRestart");

        Toast t = Toast.makeText(this, "Selamat Datang Kembali", Toast.LENGTH_LONG);
        t.show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Kondisi", "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Kondisi", "onResume");
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this).setMessage("Ingin keluar dari aplikasi?");
        alert.setTitle("Keluar?");
        alert.setIcon(android.R.drawable.ic_dialog_alert);

        alert.setPositiveButton("KELUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });

        alert.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Kondisi", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Kondisi", "onDestroy");
        AlertDialog.Builder alert = new AlertDialog.Builder(this).setMessage("Ingin keluar dari aplikasi?");
        alert.show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonPindah:
                Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
                startActivity(intent);
                intent.putExtra("Nama", "Bondan Satrio");
                intent.putExtra("Usia", 18);
                intent.putExtra("Status", false);
                startActivity(intent);
                break;
            case R.id.buttonBrowser:
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(browser);
                break;
        }
    }
}
