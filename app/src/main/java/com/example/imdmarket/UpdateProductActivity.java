package com.example.imdmarket;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        EditText codigo = findViewById(R.id.codigoText);
        EditText nome = findViewById(R.id.nomeText);
        EditText descricao = findViewById(R.id.descricaoText);
        EditText estoque = findViewById(R.id.estoqueText);

        Button limpar = findViewById(R.id.btn_limpar);
        limpar.setOnClickListener(view -> {
            codigo.setText("", TextView.BufferType.NORMAL);
            nome.setText("", TextView.BufferType.NORMAL);
            descricao.setText("", TextView.BufferType.NORMAL);
            estoque.setText("", TextView.BufferType.NORMAL);
        });
    }
}