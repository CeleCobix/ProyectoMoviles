package com.example.comercializadoranorte.ui.pedidos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.comercializadoranorte.data.model.Pedido;
import com.example.comercializadoranorte.data.repository.PedidoRepository;
import java.util.List;

public class PedidoViewModel extends ViewModel {

    private final PedidoRepository repository = new PedidoRepository();
    private final MutableLiveData<List<Pedido>> pedidos = new MutableLiveData<>();
    private final MutableLiveData<String> mensajeEstado = new MutableLiveData<>();

    public LiveData<List<Pedido>> getPedidos() { return pedidos; }
    public LiveData<String> getMensajeEstado() { return mensajeEstado; }

    public void cargarPedidos() {
        pedidos.setValue(repository.obtenerTodos());
    }

    public void actualizarEstadoPedido(String pedidoId, String nuevoEstado) {
        repository.actualizarEstado(pedidoId, nuevoEstado);
        mensajeEstado.setValue("Estado actualizado: " + nuevoEstado);
        cargarPedidos();
    }
}