package com.example.comercializadoranorte;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.comercializadoranorte.ui.cliente.ClientesFragment;
import com.example.comercializadoranorte.ui.home.HomeFragment;
import com.example.comercializadoranorte.ui.pedidos.PedidosFragment;
import com.example.comercializadoranorte.ui.reportes.ReportesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNavBar);

        // Cargar fragmento inicial
        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (id == R.id.pedidos) {
                replaceFragment(new PedidosFragment());
                return true;
            } else if (id == R.id.clientes) {
                replaceFragment(new ClientesFragment());
                return true;
            } else if (id == R.id.reportes) {
                replaceFragment(new ReportesFragment());
                return true;
            }
            return false;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
