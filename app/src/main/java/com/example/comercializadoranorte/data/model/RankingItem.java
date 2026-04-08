package com.example.comercializadoranorte.data.model;

public class RankingItem {
    private Cliente cliente;
    private double montoTotal;
    private int porcentaje;

    public RankingItem(Cliente cliente, double montoTotal, int porcentaje) {
        this.cliente = cliente;
        this.montoTotal = montoTotal;
        this.porcentaje = porcentaje;
    }

    public Cliente getCliente() { return cliente; }
    public double getMontoTotal() { return montoTotal; }
    public int getPorcentaje() { return porcentaje; }

    public String getNombreCliente() { return cliente.getNombre(); }
}