package com.example.imdmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button registerProduct = findViewById(R.id.go_register_product);
        Button listProduct = findViewById(R.id.go_list_product);
        Button deleteProduct = findViewById(R.id.go_delete_product);
        Button updateProduct = findViewById(R.id.go_update_product);

        registerProduct.setOnClickListener(view -> startActivity(new Intent(this, RegisterProductActivity.class)));
        listProduct.setOnClickListener(view -> startActivity(new Intent(this, ListProductActivity.class)));
        deleteProduct.setOnClickListener(view -> startActivity(new Intent(this, DeleteProductActivity.class)));
        updateProduct.setOnClickListener(view -> startActivity(new Intent(this, UpdateProductActivity.class)));
    }
}