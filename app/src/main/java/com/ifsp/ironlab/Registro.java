package com.ifsp.ironlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText EdtNome, EdtEmail, EdtPeso, EdtAltura, EdtIdade;
    Button btnCancelar, btnCadastrar;
    SQLiteDatabase ironlab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        EdtNome = findViewById(R.id.etxtSenhaLogin);
        EdtEmail = findViewById(R.id.editTextEmail);
        EdtPeso = findViewById(R.id.editTextPeso);
        EdtAltura = findViewById(R.id.editTextAltura);
        EdtIdade = findViewById(R.id.editTextIdade);
        recebeDados();

        btnCancelar = findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent perfil = new Intent(getApplicationContext(), Perfil.class);
                perfil.setFlags(perfil.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(perfil);
            }
        });

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                Toast.makeText(getApplicationContext(), "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                startActivity(login);
            }
        });

        acessaDB();
    }

    public void acessaDB(){
        try{
            ironlab = openOrCreateDatabase("ironlab", MODE_PRIVATE, null);
            ironlab.execSQL("Create table if not exists usuarios("+
                    "id integer not null primary key autoincrement, nome varchar(60), email vachar(60), peso decimal(6,2), " +
                    "altura decimal(4,2), idade int)");
        }
        catch (Exception e){
            System.out.println("Erro ao inserir SQL: "+e.getMessage());
        }
    }

    public void registrar (View view){
        try {
            ironlab.execSQL("insert into usuarios values(null,'"+ EdtNome.getText()+"', '"+
                    EdtEmail.getText()+"', "+EdtPeso.getText()+", "+EdtAltura.getText()+", "+
                    EdtIdade.getText()+")");
            Toast.makeText(this, "Inserido", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            System.out.println("Erro inserir: "+e.getMessage());
        }
    }

    public void recebeDados(){
        Bundle recebeDados = getIntent().getExtras();

        if (recebeDados != null){
            String nome, email, peso, altura, idade;
            nome = recebeDados.getString("nome");
            email = recebeDados.getString("email");
            peso = recebeDados.getString("peso");
            altura = recebeDados.getString("altura");
            idade = recebeDados.getString("idade");
            if(nome.length() > 0){
                EdtNome.setText("" + nome);
            }else{
                EdtNome.setText("");
            }
            if(email.length() > 0){
                EdtEmail.setText("" + email);
            }else{
                EdtEmail.setText("");
            }
            if(peso.length() > 0){
                EdtPeso.setText("" + peso);
            }else{
                EdtPeso.setText("");
            }
            if(altura.length() > 0){
                EdtAltura.setText("" + altura);
            }else{
                EdtAltura.setText("");
            }
            if(idade.length() > 0){
                EdtIdade.setText("" + idade);
            }else{
                EdtIdade.setText("");
            }
        }else{
            return;
        }
        /*EdtNome.setText("" + nome);
        EdtEmail.setText("" + email);
        EdtPeso.setText("" + peso);
        EdtAltura.setText("" + altura);
        EdtIdade.setText("" + idade);*/
    }
}