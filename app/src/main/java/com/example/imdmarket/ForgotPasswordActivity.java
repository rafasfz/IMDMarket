package com.example.imdmarket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button salvar = findViewById(R.id.btn_salvar_credenciais);
        Button voltar = findViewById(R.id.btn_back_to_login);

        salvar.setOnClickListener(view -> {
            String login = ((EditText) findViewById(R.id.login)).getText().toString();
            String senha = ((EditText) findViewById(R.id.senha)).getText().toString();

            SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("login", login);
            editor.putString("senha", senha);

            editor.apply();

            Toast.makeText(this, "Credenciais salvas com sucesso!", Toast.LENGTH_LONG).show();

            startActivity(new Intent(this, MainActivity.class));
        });

        voltar.setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));
    }
}