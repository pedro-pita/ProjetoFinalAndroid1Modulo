package com.zicronofandroid.avaliacaofinal1pedropita;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class professores extends AppCompatActivity {
    RecyclerView rv;
    String[] nomeProf,especialidadeProf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professores);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        criarProfessores();
    }
    void criarProfessores() {
        List<Professor> professores= new ArrayList<Professor>();
        Resources res = getResources();
        nomeProf = res.getStringArray(R.array.nomeProf);
        especialidadeProf = res.getStringArray(R.array.especialidadeProf);
        for(int i=0;i<nomeProf.length;i++){
             Professor p1=new Professor(nomeProf[i],especialidadeProf[i],R.drawable.epcc);
             professores.add(p1);
        }

        professoresAdapter mandarAdapter= new professoresAdapter(professores,this);
        rv.setAdapter(mandarAdapter);
    }
    class Professor {
        public String nome;
        public String especialidade;
        public int imageId;

        Professor(String nome, String especialidade, int imageId) {
            this.nome = nome;
            this.especialidade = especialidade;
            this.imageId = imageId;
        }
    }
}