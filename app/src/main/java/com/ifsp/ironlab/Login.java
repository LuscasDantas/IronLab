package com.ifsp.ironlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class Login extends AppCompatActivity {

    EditText editTextEmail, etxtLoginSenha;
    Button entrarBtn, registrarBtn, btnCancelar;
    SQLiteDatabase ironlab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextEmail = findViewById(R.id.editTextEmail);
        etxtLoginSenha = findViewById(R.id.etxtSenhaLogin);

        entrarBtn = findViewById(R.id.entrarBtn);
        entrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AcessarDados();
            }
        });

        registrarBtn = findViewById(R.id.registrarBtn);
        registrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(getApplicationContext(), Registro.class);
                startActivity(registro);
            }
        });

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

    public void AcessarDados(){
        String Usuario, senha;

        Usuario = editTextEmail.getText().toString();
        senha = etxtLoginSenha.getText().toString();

        if (Usuario.isEmpty() && senha.isEmpty()){
            Toast.makeText(getApplicationContext(),"Preencha todos os dados de campo de login", Toast.LENGTH_LONG).show();
        }
        else{
            if (Usuario.isEmpty() && senha.length() > 0){
                Toast.makeText(getApplicationContext(),"Preencha o campo do usuario", Toast.LENGTH_LONG).show();
            }
            else{
                if (senha.isEmpty() && Usuario.length() > 0){
                    Toast.makeText(getApplicationContext(),"Preencha o campo do senha", Toast.LENGTH_LONG).show();
                }
                else {
                    if (Usuario.equals("breno@gmail.com") && senha.equals("123456") ||
                            Usuario.equals("lucas@example.com") && senha.equals("q1w2e3r4")) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("usuario", Usuario);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Login realizado com sucesso", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}