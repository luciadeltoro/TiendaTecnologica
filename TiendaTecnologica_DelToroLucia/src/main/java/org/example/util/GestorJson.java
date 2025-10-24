package org.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.modelo.Tienda;

import java.io.File;
import java.io.IOException;

public class GestorJson {

    public static Tienda cargarTienda(String rutaArchivo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(rutaArchivo), Tienda.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
