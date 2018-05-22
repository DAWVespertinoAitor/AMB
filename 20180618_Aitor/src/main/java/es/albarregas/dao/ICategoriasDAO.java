/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Categorias;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface ICategoriasDAO {
    public void addCategoria(Categorias categorias);
    public ArrayList<Categorias> getCategorias();
    public Categorias getCategoria(int idCategoria);
//    public ArrayList<Categorias> getAlumnosEquipo();
//    public ArrayList<Categorias> getAlumnosSinEquipo();
    
    public void updateCategoria(Categorias categorias);
    public void deleteCategoria(Categorias categorias);
    public void closeConnection();
}
