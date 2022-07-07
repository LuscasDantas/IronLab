package com.ifsp.ironlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    TextView TxtNome, TxtEmail, TxtPeso, TxtAltura, TxtIdade, txtImc;
    Button btnNovoUsuario, btnEditar, btnHome;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        btnNovoUsuario = findViewById(R.id.btnNovoUsuario);
        btnEditar = findViewById(R.id.btnEditar);
        btnHome = findViewById(R.id.btnHome);
        SettarDados();

        btnNovoUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), Home.class);
                home.putExtra("usuario", usuario);
                startActivity(home);
            }
        });
    }

    public void SettarDados(){
        Bundle recebeDados = getIntent().getExtras();
        String nome;
        nome = recebeDados.getString("usuario");
        usuario = nome;

        TxtNome = findViewById(R.id.lblNome);
        TxtEmail = findViewById(R.id.lblEmail);
        TxtPeso = findViewById(R.id.lblPeso);
        TxtAltura = findViewById(R.id.lblAltura);
        TxtIdade = findViewById(R.id.lblIdade);
        txtImc = findViewById(R.id.lblImc);

        if (nome.equals("Breno")) {
            TxtNome.setText("Breno");
            TxtEmail.setText("breno@gmail.com");
            TxtPeso.setText("110 kg");
            TxtAltura.setText("182cm");
            TxtIdade.setText("20 anos");
            txtImc.setText("33,21");
        }
        if (nome.equals("Lucas")) {
            TxtNome.setText("Lucas");
            TxtEmail.setText("lucas@example.com");
            TxtPeso.setText("64 kg");
            TxtAltura.setText("170 cm");
            TxtIdade.setText("24 anos");
            txtImc.setText("22,15");
        }

        /*Intent intent = new Intent(getApplicationContext(), Registro.class);
        intent.putExtra("nome",Nome);
        intent.putExtra("email",Email);
        intent.putExtra("peso",Peso);
        intent.putExtra("altura",Altura);
        intent.putExtra("idade",Idade);
        startActivity(intent);*/
    }
}