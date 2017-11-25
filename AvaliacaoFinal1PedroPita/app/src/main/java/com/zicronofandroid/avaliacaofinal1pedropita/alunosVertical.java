package com.zicronofandroid.avaliacaofinal1pedropita;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class alunosVertical extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        if (savedInstanceState == null) {
            alunosDetalhes details = new alunosDetalhes();
            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}