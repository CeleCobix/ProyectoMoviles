package com.example.comercializadoranorte.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;

public class NuevaContrasenaActivity extends AppCompatActivity {

    private NuevaContrasenaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_contrasena);

        viewModel = new ViewModelProvider(this).get(NuevaContrasenaViewModel.class);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());
    }
}