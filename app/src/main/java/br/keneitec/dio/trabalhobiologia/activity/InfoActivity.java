package br.keneitec.dio.trabalhobiologia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.keneitec.dio.trabalhobiologia.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().hide();
    }
}