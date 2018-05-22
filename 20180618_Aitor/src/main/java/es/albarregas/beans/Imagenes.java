/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author aitor
 */
public class Imagenes implements Serializable {
    
    private int idImagen;
    private int idProducto;
    private String imagen;
    private int idx;

    public Imagenes() {
    }

    public Imagenes(int idImagen, int idProducto, String imagen, int idx) {
        this.idImagen = idImagen;
        this.idProducto = idProducto;
        this.imagen = imagen;
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
