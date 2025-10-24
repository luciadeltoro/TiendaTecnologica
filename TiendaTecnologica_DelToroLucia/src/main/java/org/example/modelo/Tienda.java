package org.example.modelo;

import java.util.List;

public class Tienda {

    private String nombre;
    private List<Categoria> categorias;
    private List<Usuario> usuarios;

    public Tienda() {
    }

    public Tienda(String nombre, List<Categoria> categorias, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.categorias = categorias;
        this.usuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
