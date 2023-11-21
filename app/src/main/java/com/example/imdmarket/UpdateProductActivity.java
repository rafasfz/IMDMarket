package com.example.imdmarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        Button update_button = findViewById(R.id.btn_update);

        update_button.setOnClickListener(view-> {

            try {
                ProductRepository productRepository = new ProductRepository(getApplicationContext());
                ProductEntity product = productRepository.getProductById(Integer.valueOf(codigo.getText().toString()));

                if (!nome.getText().toString().matches("")) {
                    product.name = nome.getText().toString();
                }

                if (!descricao.getText().toString().matches("")) {
                    product.description = descricao.getText().toString();
                }

                if (!estoque.getText().toString().matches("")) {
                    product.stock = Integer.valueOf(estoque.getText().toString());
                }

                productRepository.updateProduct(product);

                startActivity(new Intent(this, HomeActivity.class));
            } catch (Exception e) {
                Toast.makeText(this, "Erro ao editar!", Toast.LENGTH_LONG).show();
            }


        });
    }
}