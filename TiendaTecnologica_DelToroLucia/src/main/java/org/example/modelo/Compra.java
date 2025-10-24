package org.example.modelo;

public class Compra {

    private int compraId;
    private int productoId;
    private int cantidad;
    private String fecha;

    public Compra() {
    }

    public Compra(int compraId, int productoId, int cantidad, String fecha) {
        this.compraId = compraId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
