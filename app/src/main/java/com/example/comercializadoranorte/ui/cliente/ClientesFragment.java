package com.example.comercializadoranorte.ui.cliente;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ClientesFragment extends Fragment {

    private ClientesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clientes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ClientesViewModel.class);

        viewModel.getClientes().observe(getViewLifecycleOwner(), clientes -> {
            // Aquí actualizas el RecyclerView con los clientes
        });

        viewModel.cargarClientes();

        /*FloatingActionButton fabNuevo = view.findViewById(R.id.fab_nuevo_cliente);
        if (fabNuevo != null) {
            fabNuevo.setOnClickListener(v ->
                    startActivity(new Intent(getActivity(), NuevoClienteActivity.class))
            );
        }*/
    }
}