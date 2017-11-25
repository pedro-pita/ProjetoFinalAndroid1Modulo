package com.zicronofandroid.avaliacaofinal1pedropita;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class professoresDetalhes extends AppCompatActivity {
    TextView nomeView, especialidadeView,idadeView;
    String[] idadeProf;
    Intent intent;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor_details);
        textViews();
    }
    void textViews(){
        nomeView = (TextView) findViewById(R.id.nomeView);
        especialidadeView = (TextView) findViewById(R.id.especialidadeView);
        idadeView = (TextView) findViewById(R.id.idadeView);
        carregarArray();
    }
    void carregarArray(){
        res = getResources();
        idadeProf = res.getStringArray(R.array.idadeProf);
        receberEnviarValores();
    }
    void receberEnviarValores(){
        intent = getIntent();
        nomeView.setText(intent.getStringExtra("nome"));
        especialidadeView.setText(intent.getStringExtra("especialidade"));
        idadeView.setText(idadeProf[intent.getIntExtra("posicao",0)]);
    }
}