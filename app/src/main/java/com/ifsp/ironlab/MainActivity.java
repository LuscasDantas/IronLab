package com.ifsp.ironlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView treinoMsgBox;
    RadioGroup escolhaTreinoGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        treinoMsgBox = findViewById(R.id.treinoMsgBox);
        escolhaTreinoGroup = findViewById(R.id.escolhaTreinoGroup);

        int diasTreinados = 0;

        if (diasTreinados == 0) {
            treinoMsgBox.setText("O que deseja treinar primeiro?");
        }
        else{
            treinoMsgBox.setText("O treino do dia é perna!");
        }
    }



}