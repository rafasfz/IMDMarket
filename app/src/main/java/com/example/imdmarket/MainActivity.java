package com.example.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String login;
    private String senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.btn_salvar_credenciais);
        TextView forgotPassword = findViewById(R.id.forgot_password);

        initializeSharedPreferences();
        loginButton.setOnClickListener(view -> {
            if (isCorrectCredential())
                startActivity(new Intent(this, HomeActivity.class));
            else
                Toast.makeText(this, "Credenciais incorretas!", Toast.LENGTH_LONG).show();
        });

        forgotPassword.setOnClickListener(view -> startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }

    private boolean isCorrectCredential() {
        String login = ((EditText) findViewById(R.id.login)).getText().toString();
        String senha = ((EditText) findViewById(R.id.senha)).getText().toString();
        return this.login.equals(login) && this.senha.equals(senha);
    }

    private void initializeSharedPreferences() {

        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        login = preferences.getString("login", null);
        senha = preferences.getString("senha", null);

        if (login == null || senha == null) {
            editor.putString("login", "admin");
            editor.putString("senha", "admin");
            login = "admin";
            senha = "admin";
            editor.apply();
        }
    }
}