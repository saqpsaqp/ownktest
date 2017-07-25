package com.ownk.project.models;

import java.util.List;

public class Vendedor {
    private int idVend;
    private String nombres;
    private String apellidos;
    private String cedula;
    private List<Producto> productos;
  

    public int getIdVend() {
        return idVend;
    }
    
    public void setIdVend(int idVend) {
        this.idVend = idVend;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    

    @Override
    public String toString() {
        return "Vendedor{" + "idVend=" + idVend + ", nombres=" + nombres + ", apellidos=" + apellidos + ", cedula=" + cedula + '}';
    }  
}
