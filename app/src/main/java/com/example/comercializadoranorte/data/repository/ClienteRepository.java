package com.example.comercializadoranorte.data.repository;

import com.example.comercializadoranorte.data.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> obtenerTodos() {
        return listaClientes;
    }

    public void agregar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void eliminar(String clienteId) {
        listaClientes.removeIf(c -> c.getId().equals(clienteId));
    }
}