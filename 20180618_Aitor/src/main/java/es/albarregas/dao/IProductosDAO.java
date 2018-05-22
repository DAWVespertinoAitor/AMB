/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Productos;
import java.util.ArrayList;

/**
 *
 * @author aitor
 */
public interface IProductosDAO {
    public void addProducto(Productos productos);
    public ArrayList<Productos> getProductos();
    public Productos getProducto(int idProducto);
//    public ArrayList<Categorias> getAlumnosEquipo();
//    public ArrayList<Categorias> getAlumnosSinEquipo();
    
    public void updateProducto(Productos productos);
    public void deleteProducto(Productos productos);
    public void closeConnection();
}
