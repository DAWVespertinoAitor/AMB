/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.daofactory;

import es.albarregas.dao.CategoriasDAO;
import es.albarregas.dao.ClientesDAO;
import es.albarregas.dao.ICategoriasDAO;
import es.albarregas.dao.IClientesDAO;
import es.albarregas.dao.IImagenesDAO;
import es.albarregas.dao.ILineasPedidosDAO;
import es.albarregas.dao.IMarcasDAO;
import es.albarregas.dao.IPedidosDAO;
import es.albarregas.dao.IProductosDAO;
import es.albarregas.dao.IUsuariosDAO;
import es.albarregas.dao.ImagenesDAO;
import es.albarregas.dao.LineasPedidosDAO;
import es.albarregas.dao.MarcasDAO;
import es.albarregas.dao.PedidosDAO;
import es.albarregas.dao.ProductosDAO;
import es.albarregas.dao.UsuariosDAO;

/**
 *
 * @author Daw2
 */
public class MySQLDAOFactory extends DAOFactory{

    @Override
    public ICategoriasDAO getCategoriasDAO() {
        return new CategoriasDAO();
    }

    @Override
    public IClientesDAO getClientesDAO() {
        return new ClientesDAO();
    }

    @Override
    public IImagenesDAO getImagenesDAO() {
        return new ImagenesDAO();
    }

    @Override
    public IMarcasDAO getMarcasDAO() {
        return new MarcasDAO();
    }

    @Override
    public IPedidosDAO getPedidosDAO() {
        return new PedidosDAO();
    }

    @Override
    public IProductosDAO getProductosDAO() {
        return new ProductosDAO();
    }

    @Override
    public IUsuariosDAO getUsuariosDAO() {
        return new UsuariosDAO();
    }

    @Override
    public ILineasPedidosDAO getLineasPedidosDAO() {
        return new LineasPedidosDAO();
    }
    
}
