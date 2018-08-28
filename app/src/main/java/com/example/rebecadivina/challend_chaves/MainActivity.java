package com.example.rebecadivina.challend_chaves;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    Button btnEnviar;
    EditText txNome, txIdade,txEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);
    }


    public void onClick(View v) {
        Button btn = findViewById(v.getId());
        if(btn != null){

            txNome = findViewById(R.id.txNome);
            String nome = txNome.getText().toString();

            txIdade = findViewById(R.id.txIdade);
            String idade = txIdade.getText().toString();

            txEmail = findViewById(R.id.txEmail);
            String email = txEmail.getText().toString();

            String mensagem = cabecalho(nome, idade, email);
            mandarEmail(email, mensagem, "Mandar email para: " + nome);
        }


    }
    public String cabecalho(String nome, String idade, String email){
        return "Nome: " + nome + "\nIdade: " + idade + "\nEmail: " + email;
    }
    public void mandarEmail(String email, String msg, String titulo){
        String to = email;
        String subject = titulo;
        String message = msg;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "E-mail"));
    }


}
