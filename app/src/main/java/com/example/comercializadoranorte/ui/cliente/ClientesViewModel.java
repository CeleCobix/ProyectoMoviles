package com.example.comercializadoranorte.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.comercializadoranorte.data.model.Cliente;
import com.example.comercializadoranorte.data.repository.ClienteRepository;
import java.util.List;

public class ClientesViewModel extends ViewModel {

    private final ClienteRepository repository = new ClienteRepository();
    private final MutableLiveData<List<Cliente>> clientes = new MutableLiveData<>();

    public LiveData<List<Cliente>> getClientes() {
        return clientes;
    }

    public void cargarClientes() {
        clientes.setValue(repository.obtenerTodos());
    }
}