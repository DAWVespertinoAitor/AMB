/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.daofactory;

import es.albarregas.dao.ICategoriasDAO;
import es.albarregas.dao.IClientesDAO;
import es.albarregas.dao.IImagenesDAO;
import es.albarregas.dao.IMarcasDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductosDAO;
import es.albarregas.dao.IUsuariosDAO;
import es.albarregas.dao.ILineasPedidosDAO;

/**
 *
 * @author Daw2
 */
public abstract class DAOFactory {
    
    public abstract ICategoriasDAO getCategoriasDAO();
    public abstract IClientesDAO getClientesDAO();
    public abstract IImagenesDAO getImagenesDAO();
    public abstract IMarcasDAO getMarcasDAO();
    public abstract IPedidosDAO getPedidosDAO();
    public abstract IProductosDAO getProductosDAO();
    public abstract IUsuariosDAO getUsuariosDAO();
    public abstract ILineasPedidosDAO getLineasPedidosDAO();
    
    public static DAOFactory getDAOFactory(){
        
        DAOFactory daof = null;
        
        daof = new MySQLDAOFactory();
        
        return daof;
    }
    
}
