package com.example.comercializadoranorte.ui.cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.comercializadoranorte.R;
import com.example.comercializadoranorte.data.model.Cliente;

public class ClienteDetalleActivity extends Fragment {

    private ClienteDetalleViewModel viewModel;
    private TextView tvNombre, tvRfc, tvTelefono, tvEmail, tvDireccion, tvRegistro, tvStatus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cliente_detalle, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        tvNombre = view.findViewById(R.id.tvNombreEmpresa);
        tvRfc = view.findViewById(R.id.tvRfcValue);
        tvTelefono = view.findViewById(R.id.tvTelefonoValue);
        tvEmail = view.findViewById(R.id.tvEmailValue);
        tvDireccion = view.findViewById(R.id.tvDireccionValue);
        tvRegistro = view.findViewById(R.id.tvRegistroValue);
        tvStatus = view.findViewById(R.id.tvStatus);

        view.findViewById(R.id.btnBack).setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ClienteDetalleViewModel.class);

        viewModel.getCliente().observe(getViewLifecycleOwner(), this::updateUI);

        Cliente mockCliente = new Cliente(
                "1",
                "Industrial del Norte S.A. de C.V.",
                "INO880415-K32",
                "+52 (614) 123 4567",
                "contacto@industrialnorte.mx",
                "Ave. de las Industrias 4501,\nParque Industrial Norte,\nChihuahua, Chih. CP 31100\nMéxico",
                "14 Octubre, 2021",
                true
        );
        viewModel.setCliente(mockCliente);
    }

    private void updateUI(Cliente cliente) {
        if (cliente != null) {
            tvNombre.setText(cliente.getNombre());
            tvRfc.setText(cliente.getRfc());
            tvTelefono.setText(cliente.getTelefono());
            tvEmail.setText(cliente.getCorreo());
            tvDireccion.setText(cliente.getDireccion());
            tvRegistro.setText(cliente.getFechaRegistro());
            tvStatus.setText(cliente.isActivo() ? R.string.estado_activo : R.string.boton_cancelar); // Simplified
        }
    }
}