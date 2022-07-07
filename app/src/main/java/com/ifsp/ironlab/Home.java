package com.ifsp.ironlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity  {

   //TextView treinoMsgBox;
    //RadioGroup escolhaTreinoGroup;

    ImageButton peitoBtn;
    ImageButton bracoBtn;
    ImageButton pernaBtn;
    ImageButton homeBtn;
    ImageButton treinoBtn;
    ImageButton perfilBtn;
    ImageButton menuBtn;
    TextView txtUsuario;
    String usuario = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_home);

        peitoBtn = findViewById(R.id.peitoBtn);
        peitoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent treinoPeito = new Intent(getApplicationContext(), TreinoPeito.class);
                startActivity(treinoPeito);
            }
        });

        bracoBtn = findViewById(R.id.bracoBtn);
        bracoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent treinoBraco = new Intent(getApplicationContext(), TreinoBraco.class);
                startActivity(treinoBraco);
            }
        });

        pernaBtn = findViewById(R.id.pernaBtn);
        pernaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent treinoPerna = new Intent(getApplicationContext(), TreinoPerna.class);
                startActivity(treinoPerna);
            }
        });

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), Home.class);
                startActivity(home);
            }
        });

        treinoBtn = findViewById(R.id.treinoBtn);
        treinoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent treino = new Intent(getApplicationContext(), Registro.class);
                startActivity(treino);
            }
        });

        perfilBtn = findViewById(R.id.perfilBtn);
        perfilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perfil = new Intent(getApplicationContext(), Perfil.class);
                perfil.putExtra("usuario", usuario);
                startActivity(perfil);
            }
        });

        menuBtn = findViewById(R.id.menuBtn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent(getApplicationContext(), Login.class);
                startActivity(menu);
            }
        });

        /*treinoMsgBox = findViewById(R.id.treinoMsgBox);

        Spinner spinnerTreino = findViewById(R.id.spinnerTreino);
        ArrayAdapter<CharSequence>
                adapter = ArrayAdapter.createFromResource(
                this, R.array.treinos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTreino.setAdapter(adapter);
        spinnerTreino.setOnItemSelectedListener(this);*/
        recebeDados();
    }

    public void recebeDados(){

        txtUsuario = findViewById(R.id.txtUsuario);
        Bundle recebeDados = getIntent().getExtras();
        String nome;
        nome = recebeDados.getString("usuario");

        if (nome.equals("breno@gmail.com")) {
            txtUsuario.setText(", Breno");
            usuario = "Breno";
        }
        if (nome.equals("lucas@example.com")) {
            txtUsuario.setText(", Lucas");
            usuario = "Lucas";
        }

    }

    /*@Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String texto = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), texto, Toast.LENGTH_SHORT).show();
        escolheTreino(texto);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void escolheTreino(String texto){
        int diasTreinados = 1;

        if ("Braços".equals(texto) ) {
            treinoMsgBox.setText("O que deseja treinar primeiro?");
        }
        else{
            treinoMsgBox.setText(texto);
        }
    }*/


}