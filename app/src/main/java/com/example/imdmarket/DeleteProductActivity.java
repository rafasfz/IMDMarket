package com.example.imdmarket;

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
    }
}