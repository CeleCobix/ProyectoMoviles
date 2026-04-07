package com.example.comercializadoranorte.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.comercializadoranorte.data.model.Cliente;

public class ClienteDetalleViewModel extends ViewModel {
    private final MutableLiveData<Cliente> cliente = new MutableLiveData<>();

    public LiveData<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clienteData) {
        cliente.setValue(clienteData);
    }
}