/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Marcas;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IMarcasDAO {
    public void addMarca(Marcas marcas);
    public ArrayList<Marcas> getMarcas();
    public Marcas getMarca(int idMarca);
//    public ArrayList<Categorias> getAlumnosEquipo();
//    public ArrayList<Categorias> getAlumnosSinEquipo();
    
    public void updateMarca(Marcas marcas);
    public void deleteMarca(Marcas marcas);
    public void closeConnection();
}
