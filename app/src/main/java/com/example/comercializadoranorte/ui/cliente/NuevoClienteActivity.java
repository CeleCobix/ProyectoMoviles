package com.example.comercializadoranorte.ui.cliente;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;

public class NuevoClienteActivity extends AppCompatActivity {

    private NuevoClienteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cliente);

        viewModel = new ViewModelProvider(this).get(NuevoClienteViewModel.class);
    }
}