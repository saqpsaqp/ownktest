package com.ownk.practical.backend.model;

public class Vendedor {
    private int idVend;
    private String nombres;
    private String apellidos;
    private String cedula;

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
    
    
}
