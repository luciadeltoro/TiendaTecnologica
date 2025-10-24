package org.example.modelo;

import java.util.Map;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private Map<String, String> caracteristicas;
    private int inventario;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, String descripcion,
                    Map<String, String> caracteristicas, int inventario) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String, String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Map<String, String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public boolean reducirInventario(int cantidad) {
        if (cantidad <= inventario) {
            inventario -= cantidad;
            return true;
        } else {
            return false; // No hay suficiente stock
        }
    }
}
