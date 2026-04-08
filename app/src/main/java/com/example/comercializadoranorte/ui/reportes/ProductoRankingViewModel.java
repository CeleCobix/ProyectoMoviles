package com.example.comercializadoranorte.ui.reportes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.comercializadoranorte.data.model.Producto;
import com.example.comercializadoranorte.data.model.ProductoRanking;
import java.util.ArrayList;
import java.util.List;

public class ProductoRankingViewModel extends ViewModel {

    private final MutableLiveData<List<ProductoRanking>> _productosRanking = new MutableLiveData<>();
    public LiveData<List<ProductoRanking>> productosRanking = _productosRanking;

    private final MutableLiveData<String> _totalVentasGlobal = new MutableLiveData<>();
    public LiveData<String> totalVentasGlobal = _totalVentasGlobal;

    public void cargarProductos() {
        List<ProductoRanking> lista = new ArrayList<>();

        lista.add(new ProductoRanking(new Producto("1", "Reloj Inteligente Serie X", "El estandarte de nuestra línea de lujo con sensor avanzado.", "ELECTRÓNICA", 0, 0), 4829, 100));
        lista.add(new ProductoRanking(new Producto("2", "Headset Studio Pro", "Sonido envolvente de alta fidelidad.", "ELECTRÓNICA", 0, 0), 3200, 66));
        lista.add(new ProductoRanking(new Producto("3", "Cámara 4K Alpha", "Fotografía profesional con sensor CMOS.", "FOTOGRAFÍA", 0, 0), 2100, 43));
        lista.add(new ProductoRanking(new Producto("4", "Laptop Ultra Slim", "Productividad extrema con procesador i7.", "PRODUCTIVIDAD", 0, 0), 1500, 31));

        _productosRanking.setValue(lista);
        _totalVentasGlobal.setValue("14.2k");
    }
}