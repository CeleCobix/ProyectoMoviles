package com.example.comercializadoranorte.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.comercializadoranorte.data.model.Cliente;
import com.example.comercializadoranorte.data.repository.ClienteRepository;

public class NuevoClienteViewModel extends ViewModel {

    private final ClienteRepository repository = new ClienteRepository();
    private final MutableLiveData<Boolean> clienteGuardado = new MutableLiveData<>();
    private final MutableLiveData<String> errorMensaje = new MutableLiveData<>();

    public LiveData<Boolean> getClienteGuardado() { return clienteGuardado; }
    public LiveData<String> getErrorMensaje() { return errorMensaje; }

    public void guardarCliente(String nombre, String telefono, String correo, String direccion) {
        if (nombre.isEmpty() || telefono.isEmpty()) {
            errorMensaje.setValue("Nombre y teléfono son obligatorios");
            return;
        }
        String id = String.valueOf(System.currentTimeMillis());
        repository.agregar(new Cliente(id, nombre, telefono, correo, direccion));
        clienteGuardado.setValue(true);
    }
}