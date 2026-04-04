package com.example.comercializadoranorte.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;

public class RecuperarAccesoActivity extends AppCompatActivity {

    private RecuperarAccesoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_acceso);

        viewModel = new ViewModelProvider(this).get(RecuperarAccesoViewModel.class);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
    }
}