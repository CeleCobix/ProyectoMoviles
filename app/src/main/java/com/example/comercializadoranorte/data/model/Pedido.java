package com.example.comercializadoranorte.data.model;

import java.util.Date;
import java.util.List;

public class Pedido {
    private String id;
    private String clienteId;
    private List<Producto> productos;
    private double total;
    private String estado; // "pendiente", "enviado", "entregado"
    private Date fecha;

    public Pedido() {}

    public Pedido(String id, String clienteId, List<Producto> productos, double total, String estado, Date fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.productos = productos;
        this.total = total;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}