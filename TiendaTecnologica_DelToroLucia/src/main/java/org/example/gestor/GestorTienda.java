package org.example.gestor;

import org.example.modelo.*;

import java.util.List;

public class GestorTienda {

    private Tienda tienda;

    public GestorTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario u : tienda.getUsuarios()) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Categoria c : tienda.getCategorias()) {
            for (Producto p : c.getProductos()) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    return p;
                }
            }
        }
        return null;
    }

    public Producto buscarProductoPorId(int id) {
        for (Categoria c : tienda.getCategorias()) {
            for (Producto p : c.getProductos()) {
                if (p.getId() == id) return p;
            }
        }
        return null;
    }

    public Categoria buscarCategoriaPorNombre(String nombreCategoria) {
        for (Categoria c : tienda.getCategorias()) {
            if (c.getNombre().equalsIgnoreCase(nombreCategoria)) {
                return c;
            }
        }
        return null;
    }

    public boolean realizarCompra(Usuario usuario, Producto producto, int cantidad) {
        if (usuario == null || producto == null) return false;
        if (!producto.reducirInventario(cantidad)) return false;

        int compraId = usuario.getHistorialCompras().size() + 1;
        Compra compra = new Compra(compraId, producto.getId(), cantidad, java.time.LocalDate.now().toString());
        usuario.realizarCompra(compra);

        return true;
    }

    public void mostrarProductosCategoria(String nombreCategoria) {
        Categoria categoria = buscarCategoriaPorNombre(nombreCategoria);
        if (categoria != null) {
            categoria.mostrarProductos();
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public void mostrarHistorialUsuario(String email) {
        Usuario usuario = buscarUsuarioPorEmail(email);
        if (usuario != null) {
            usuario.mostrarHistorial();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public void mostrarUsuarios() {
        List<Usuario> usuarios = tienda.getUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNombre() + " (" + u.getEmail() + ")");
        }
    }
}
