package com.example.comercializadoranorte.ui.cliente;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;
import com.google.android.material.textfield.TextInputEditText;

public class NuevoClienteActivity extends AppCompatActivity {

    private NuevoClienteViewModel viewModel;
    private TextInputEditText etNombre, etTelefono, etCorreo, etDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_cliente);

        viewModel = new ViewModelProvider(this).get(NuevoClienteViewModel.class);

        /*etNombre    = findViewById(R.id.et_nombre);
        etTelefono  = findViewById(R.id.et_telefono);
        etCorreo    = findViewById(R.id.et_correo);
        etDireccion = findViewById(R.id.et_direccion);
        Button btnGuardar = findViewById(R.id.btn_guardar);*/

        viewModel.getClienteGuardado().observe(this, guardado -> {
            if (guardado) {
                Toast.makeText(this, "Cliente guardado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        viewModel.getErrorMensaje().observe(this, error ->
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        );

        /*btnGuardar.setOnClickListener(v -> viewModel.guardarCliente(
                etNombre.getText().toString().trim(),
                etTelefono.getText().toString().trim(),
                etCorreo.getText().toString().trim(),
                etDireccion.getText().toString().trim()
        ));*/
    }
}