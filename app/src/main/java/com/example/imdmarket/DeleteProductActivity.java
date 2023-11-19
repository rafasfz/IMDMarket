package com.example.imdmarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        EditText codigo = findViewById(R.id.codigoText);
        Button limpar = findViewById(R.id.limpar);
        limpar.setOnClickListener(view -> codigo.setText("", TextView.BufferType.NORMAL));

        // delete_button

        Button deleteButton = findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(view -> {
            deleteProduct();
            codigo.setText("", TextView.BufferType.NORMAL);
            startActivity(new Intent(this, HomeActivity.class));
        });
    }

    public void deleteProduct() {
        EditText codigo = findViewById(R.id.codigoText);

        ProductRepository productRepository = new ProductRepository(getApplicationContext());
        productRepository.deleteProduct(Integer.valueOf(codigo.getText().toString()));

    }
}