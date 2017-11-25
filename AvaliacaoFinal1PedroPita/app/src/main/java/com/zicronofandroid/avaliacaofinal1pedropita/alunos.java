package com.zicronofandroid.avaliacaofinal1pedropita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class alunos extends AppCompatActivity {
    View myDevorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alunos);
        myDevorView=getWindow().getDecorView();
        esconderNavbar();
    }
    private void esconderNavbar(){
        myDevorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}