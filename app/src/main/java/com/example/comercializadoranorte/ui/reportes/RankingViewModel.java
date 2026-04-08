package com.example.comercializadoranorte.ui.reportes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.comercializadoranorte.data.model.Pedido;
import com.example.comercializadoranorte.data.model.RankingItem;
import com.example.comercializadoranorte.data.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class RankingViewModel extends ViewModel {
    private final MutableLiveData<List<RankingItem>> _rankingList = new MutableLiveData<>();
    public LiveData<List<RankingItem>> rankingList = _rankingList;

    public void cargarDatosRanking(List<Cliente> clientes, List<Pedido> pedidos) {
        List<RankingItem> listaProcesada = new ArrayList<>();
        double montoMaximo = 0;

        for (Cliente cliente : clientes) {
            double totalCliente = 0;
            for (Pedido pedido : pedidos) {
                if (pedido.getClienteId().equals(cliente.getId())) {
                    totalCliente += pedido.getTotal();
                }
            }
            if (totalCliente > montoMaximo) montoMaximo = totalCliente;

            listaProcesada.add(new RankingItem(cliente, totalCliente, 0));
        }

        List<RankingItem> listaFinal = new ArrayList<>();
        for (RankingItem item : listaProcesada) {
            int porcentaje = (montoMaximo > 0) ? (int) ((item.getMontoTotal() / montoMaximo) * 100) : 0;
            listaFinal.add(new RankingItem(item.getCliente(), item.getMontoTotal(), porcentaje));
        }

        _rankingList.setValue(listaFinal);
    }
}