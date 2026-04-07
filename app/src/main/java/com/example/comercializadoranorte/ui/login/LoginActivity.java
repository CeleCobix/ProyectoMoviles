package com.example.comercializadoranorte.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.MainActivity;
import com.example.comercializadoranorte.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    // La Activity solo observa, no tiene lógica de negocio
    private LoginViewModel loginViewModel;
    private TextInputEditText etUsuario;
    private TextInputEditText etContrasena;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar las vistas vinculándolas con sus IDs del XML
        etUsuario = findViewById(R.id.et_usuario);
        etContrasena = findViewById(R.id.et_contrasena);
        btnLogin = findViewById(R.id.btn_login);
        TextInputLayout tilContrasena = findViewById(R.id.tilcontrasena);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        final boolean[] isVisible = {false};

        tilContrasena.setEndIconOnClickListener(v -> {
            if (isVisible[0]) {
                // Ocultar contraseña
                etContrasena.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
                tilContrasena.setEndIconDrawable(R.drawable.ic_invisible);
                isVisible[0] = false;
            } else {
                // Mostrar contraseña
                etContrasena.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
                tilContrasena.setEndIconDrawable(R.drawable.ic_visible);
                isVisible[0] = true;
            }

            // Mantener cursor al final
            etContrasena.setSelection(etContrasena.getText().length());
        });

        loginViewModel.getLoginExitoso().observe(this, exito -> {
            if (exito) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        btnLogin.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();
            
            if (usuario.isEmpty() || contrasena.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                loginViewModel.login(usuario, contrasena);
            }
        });
    }
}
