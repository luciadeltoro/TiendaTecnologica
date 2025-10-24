package org.example.modelo;

import java.util.List;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private Direccion direccion;
    private List<Compra> historialCompras;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String email, Direccion direccion, List<Compra> historialCompras) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.historialCompras = historialCompras;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Compra> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<Compra> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public void mostrarHistorial() {
        if (historialCompras.isEmpty()) {
            System.out.println(nombre + " no tiene compras registradas.");
        } else {
            System.out.println("Historial de compras de " + nombre + ":");
            for (Compra c : historialCompras) {
                System.out.println("- Producto ID: " + c.getProductoId() +
                        ", Cantidad: " + c.getCantidad() +
                        ", Fecha: " + c.getFecha());
            }
        }
    }

    public void realizarCompra(Compra compra) {
        historialCompras.add(compra);
    }
}
