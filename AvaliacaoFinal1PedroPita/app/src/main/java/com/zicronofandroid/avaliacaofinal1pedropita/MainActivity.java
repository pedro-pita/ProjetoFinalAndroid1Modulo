package com.zicronofandroid.avaliacaofinal1pedropita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    public Button professores;
    public Button alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        professores = (Button) findViewById(R.id.professores);
        professores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaProfessores();
            }
        });
        alunos = (Button) findViewById(R.id.alunos);
        alunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaAlunos();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.alarme:
                irParaAlarme();
                break;
            case R.id.settings:
                Toast.makeText(getBaseContext(), "Settings not define.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    void irParaProfessores(){
        Intent intent = new Intent(MainActivity.this, professores.class);
        startActivity(intent);
    }
    void irParaAlarme(){
        Intent intent = new Intent(MainActivity.this, alarme.class);
        startActivity(intent);
    }
    void irParaAlunos(){
        Intent intent = new Intent(MainActivity.this, alunos.class);
        startActivity(intent);
    }
}