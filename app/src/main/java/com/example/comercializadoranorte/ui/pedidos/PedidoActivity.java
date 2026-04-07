package com.example.comercializadoranorte.ui.pedidos;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;

public class PedidoActivity extends AppCompatActivity {

    private PedidoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pedido);

        viewModel = new ViewModelProvider(this).get(PedidoViewModel.class);

        viewModel.getMensajeEstado().observe(this, mensaje ->
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        );

        String pedidoId = getIntent().getStringExtra("pedido_id");
    }
}