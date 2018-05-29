/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author aitor
 */
public class Productos implements Serializable {
    private int idProducto;
    private int idCategoria;
    private int idMarca;
    private String denominacion;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    private int stockMinimo;
    private Date fechaAlta;
    private char oferta;
    private char fueraCatalogo;

    public Productos() {
    }

    public Productos(int idProducto, int idCategoria, int idMarca, String denominacion, String descripcion, double precioUnitario, int stock, int stockMinimo, Date fechaAlta, char oferta, char fueraCatalogo) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.idMarca = idMarca;
        this.denominacion = denominacion;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.fechaAlta = fechaAlta;
        this.oferta = oferta;
        this.fueraCatalogo = fueraCatalogo;
    }

    

    public char getFueraCatalogo() {
        return fueraCatalogo;
    }

    public void setFueraCatalogo(char fueraCatalogo) {
        this.fueraCatalogo = fueraCatalogo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public char getOferta() {
        return oferta;
    }

    public void setOferta(char oferta) {
        this.oferta = oferta;
    }
    
}
