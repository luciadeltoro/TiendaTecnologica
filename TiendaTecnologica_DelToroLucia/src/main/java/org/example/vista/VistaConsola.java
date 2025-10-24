package org.example.vista;

import org.example.gestor.GestorTienda;
import org.example.modelo.Categoria;
import org.example.modelo.Producto;
import org.example.modelo.Usuario;
import org.example.modelo.Compra;

import java.util.Scanner;

public class VistaConsola {

    private GestorTienda gestor;
    private Scanner scanner;

    public VistaConsola(GestorTienda gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1" -> mostrarCategorias();
                case "2" -> mostrarProductosPorCategoria();
                case "3" -> realizarCompra();
                case "4" -> mostrarHistorialUsuario();
                case "0" -> salir = true;
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        System.out.println("Gracias por usar Mi Tienda Online. ¡Hasta pronto!");
    }

    private void mostrarMenu() {
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("1. Mostrar categorías");
        System.out.println("2. Mostrar productos por categoría");
        System.out.println("3. Realizar compra");
        System.out.println("4. Mostrar historial de un usuario");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void mostrarCategorias() {
        System.out.println("\nCategorías disponibles:");
        for (Categoria c : gestor.getTienda().getCategorias()) {
            System.out.println("- " + c.getNombre());
        }
    }

    private void mostrarProductosPorCategoria() {
        System.out.print("Introduce el nombre de la categoría: ");
        String nombreCategoria = scanner.nextLine().trim();

        Categoria categoria = gestor.buscarCategoriaPorNombre(nombreCategoria);
        if (categoria != null) {
            System.out.println("Productos en " + categoria.getNombre() + ":");
            for (Producto p : categoria.getProductos()) {
                System.out.println("- " + p.getNombre() + " | Precio: " + p.getPrecio() + " | Inventario: " + p.getInventario());
            }
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    private void realizarCompra() {
        System.out.print("Introduce el email del usuario: ");
        String email = scanner.nextLine().trim();
        Usuario usuario = gestor.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Introduce el nombre del producto: ");
        String nombreProducto = scanner.nextLine().trim();
        Producto producto = gestor.buscarProductoPorNombre(nombreProducto);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Cantidad a comprar: ");
        int cantidad;
        try {
            cantidad = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Cantidad inválida.");
            return;
        }

        if (cantidad <= 0 || cantidad > producto.getInventario()) {
            System.out.println("Cantidad no disponible.");
            return;
        }

        if (gestor.realizarCompra(usuario, producto, cantidad)) {
            System.out.println("Compra realizada correctamente.");
        } else {
            System.out.println("Error al realizar la compra.");
        }
    }

    private void mostrarHistorialUsuario() {
        System.out.print("Introduce el email del usuario: ");
        String email = scanner.nextLine().trim();
        Usuario usuario = gestor.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.println("Historial de compras de " + usuario.getNombre() + ":");
        if (usuario.getHistorialCompras().isEmpty()) {
            System.out.println("No hay compras registradas.");
        } else {
            for (Compra c : usuario.getHistorialCompras()) {
                Producto p = gestor.buscarProductoPorId(c.getProductoId());
                if (p != null) {
                    System.out.println("- " + p.getNombre() + " | Cantidad: " + c.getCantidad() + " | Fecha: " + c.getFecha());
                }
            }
        }
    }
}
