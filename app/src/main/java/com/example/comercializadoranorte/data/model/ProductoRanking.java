package com.example.comercializadoranorte.data.model;

public class ProductoRanking {
    private Producto producto;
    private int unidadesVendidas;
    private int porcentaje;

    public ProductoRanking(Producto producto, int unidadesVendidas, int porcentaje) {
        this.producto = producto;
        this.unidadesVendidas = unidadesVendidas;
        this.porcentaje = porcentaje;
    }

    public Producto getProducto() { return producto; }
    public int getUnidadesVendidas() { return unidadesVendidas; }
    public int getPorcentaje() { return porcentaje; }
}