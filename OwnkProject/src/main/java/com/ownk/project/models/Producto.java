package com.ownk.project.models;

public class Producto {
    private int idProd;
    private String codigo;
    private String descripcion;
    private int idVend;
    private Vendedor vendedor;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getIdVend() {
        return idVend;
    }

    public void setIdVend(int idVend) {
        this.idVend = idVend;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProd=" + idProd + ", codigo=" + codigo + ", descripcion=" + descripcion + ", idVend=" + idVend + ", vendedor=" + vendedor + '}';
    }
    
}
