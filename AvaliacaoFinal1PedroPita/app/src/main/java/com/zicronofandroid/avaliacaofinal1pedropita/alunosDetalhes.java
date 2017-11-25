package com.zicronofandroid.avaliacaofinal1pedropita;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class alunosDetalhes extends Fragment {
    String[] nomeAluno;
    TextView textNome;

    public static alunosDetalhes newInstance(int index) {
        alunosDetalhes lpdf = new alunosDetalhes();
        Bundle args = new Bundle();
        args.putInt("index", index);
        lpdf.setArguments(args);
        return lpdf;
    }
    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alunos_individual, container, false);
        textNome = (TextView) view.findViewById(R.id.nomeIndividual);
        nomeAluno = getResources().getStringArray(R.array.nomeAluno);
        textNome.setText(nomeAluno[getShownIndex()]);
        return view;
    }
}