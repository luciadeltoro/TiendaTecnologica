package org.example;

import org.example.gestor.GestorTienda;
import org.example.modelo.Tienda;
import org.example.util.GestorJson;
import org.example.vista.VistaConsola;

public class Main {
    public static void main(String[] args) {

        Tienda tienda = GestorJson.cargarTienda("src/main/resources/tienda.json");

        if (tienda == null) {
            System.out.println("Error al cargar los datos de la tienda.");
            return; // salir si hay fallo
        }

        GestorTienda gestor = new GestorTienda(tienda);

        VistaConsola vista = new VistaConsola(gestor);
        vista.iniciar();

        System.out.println("Gracias por comprar en Tienda Tecnológica.");
    }
}
