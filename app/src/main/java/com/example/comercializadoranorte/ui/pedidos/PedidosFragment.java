package com.example.comercializadoranorte.ui.pedidos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;

public class PedidosFragment extends Fragment {

    private PedidoViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pedidos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(PedidoViewModel.class);

        viewModel.getPedidos().observe(getViewLifecycleOwner(), pedidos -> {
            // Aquí se actualiza el RecyclerView con los pedidos
        });

        viewModel.cargarPedidos();
    }
}