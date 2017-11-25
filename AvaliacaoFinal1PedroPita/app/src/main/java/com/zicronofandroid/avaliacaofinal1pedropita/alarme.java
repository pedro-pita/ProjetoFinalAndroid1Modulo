package com.zicronofandroid.avaliacaofinal1pedropita;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alarme extends AppCompatActivity {

    private EditText edit1, edit2, edit3;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarme);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        edit3 = (EditText) findViewById(R.id.edit3);
        verificarEdits();
    }
    void verificarEdits(){
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1();
            }
            void edit1() {
                switch (edit1.length()) {
                    case 0:
                        Toast.makeText(alarme.this, "Preencha mensagem que deseja no alarme e tente novamente.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        edit2();
                }
            }
            void edit2(){
                switch (edit2.length()) {
                    case 0:
                        Toast.makeText(alarme.this, "Preencha as horas para que deseja o alarme e tente novamente.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        edit3();
                }
            }
            void edit3() {
                switch (edit3.length()) {
                    case 0:
                        Toast.makeText(alarme.this, "Preencha os minutos para que deseja o alarme e tente novamente.", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        converterValores();
                }
            }
        });
    }
    void converterValores() {
        String mensagem = (edit1.getText().toString());
        int horas = Integer.parseInt(edit2.getText().toString());
        int minutos = Integer.parseInt(edit3.getText().toString());
        enviarValores(mensagem, horas, minutos);
    }
    void enviarValores(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}