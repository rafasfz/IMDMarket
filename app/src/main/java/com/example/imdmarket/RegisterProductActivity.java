package com.example.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_product);

        Button limpar = findViewById(R.id.btn_limpar);
        limpar.setOnClickListener(view -> {
            cleanTexts();
        });

        Button create = findViewById(R.id.btn_update);
        create.setOnClickListener(view -> {
            registerProduct();
            startActivity(new Intent(this, HomeActivity.class));
        });
    }

    public void registerProduct() {
        EditText codigo = findViewById(R.id.codigoText);
        EditText nome = findViewById(R.id.nomeText);
        EditText descricao = findViewById(R.id.descricaoText);
        EditText estoque = findViewById(R.id.estoqueText);

        ProductEntity product = new ProductEntity(Integer.valueOf(codigo.getText().toString()), nome.getText().toString(), descricao.getText().toString(), Integer.valueOf(estoque.getText().toString()));

        ProductRepository productRepository = new ProductRepository(getApplicationContext());

        productRepository.insertProduct(product);
        cleanTexts();
    }

    public void cleanTexts() {
        EditText codigo = findViewById(R.id.codigoText);
        EditText nome = findViewById(R.id.nomeText);
        EditText descricao = findViewById(R.id.descricaoText);
        EditText estoque = findViewById(R.id.estoqueText);

        codigo.setText("", TextView.BufferType.NORMAL);
        nome.setText("", TextView.BufferType.NORMAL);
        descricao.setText("", TextView.BufferType.NORMAL);
        estoque.setText("", TextView.BufferType.NORMAL);
    }
}