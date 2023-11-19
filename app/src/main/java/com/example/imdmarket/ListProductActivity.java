package com.example.imdmarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        Button backToHome = findViewById(R.id.backToHome);

        backToHome.setOnClickListener(view -> startActivity(new Intent(this, HomeActivity.class)));

        ProductRepository productRepository = new ProductRepository(getApplicationContext());

        List<ProductEntity> products = productRepository.getAllProducts();
        ListView productsList = findViewById(R.id.products_list);

        ProductAdapter adapter = new ProductAdapter(this, products);
        productsList.setAdapter(adapter);

    }
}