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
    public void addAlumno(Imagenes imagenes);
    public ArrayList<Imagenes> getAlumnos();
    public Imagenes getAlumno(int idImagen);
    public ArrayList<Imagenes> getAlumnosEquipo();
    public ArrayList<Imagenes> getAlumnosSinEquipo();
    
    public void updateAlumno(Imagenes categorias);
    public void deleteAlumno(Imagenes categorias);
    public void closeConnection();
}
