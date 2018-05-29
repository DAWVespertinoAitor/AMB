/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Imagenes;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IImagenesDAO {
    public void addImagen(Imagenes imagenes);
    public ArrayList<Imagenes> getImagenes();
    public Imagenes getImagen(int idImagen);
    public void updateImagen(Imagenes imagenes);
    public void deleteImagen(Imagenes imagenes);
    public void closeConnection();
}
