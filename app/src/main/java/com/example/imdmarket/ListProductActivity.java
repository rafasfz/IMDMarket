package com.example.imdmarket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        Button backToHome = findViewById(R.id.backToHome);

        backToHome.setOnClickListener(view -> startActivity(new Intent(this, HomeActivity.class)));
    }
}