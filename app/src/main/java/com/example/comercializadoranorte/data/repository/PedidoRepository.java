package com.example.comercializadoranorte.data.repository;

import com.example.comercializadoranorte.data.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {

    private List<Pedido> listaPedidos = new ArrayList<>();

    public List<Pedido> obtenerTodos() {
        return listaPedidos;
    }

    public void agregar(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void actualizarEstado(String pedidoId, String nuevoEstado) {
        for (Pedido p : listaPedidos) {
            if (p.getId().equals(pedidoId)) {
                p.setEstado(nuevoEstado);
                break;
            }
        }
    }
}